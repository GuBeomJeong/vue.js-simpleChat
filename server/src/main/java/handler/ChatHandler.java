package handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Chat;
import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import service.ChatService;
import vo.ChatVo;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class ChatHandler extends TextWebSocketHandler {

    private ChatService chatService;
    private static final Set<WebSocketSession> connections = new CopyOnWriteArraySet<>();


    @Autowired
    public ChatHandler(ChatService chatService){
        this.chatService = chatService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println(session.getLocalAddress());
        System.out.println(session.getRemoteAddress());
        
        connections.add(session);

        sendAllConnection(convertConnectionNum());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);


        connections.remove(session);

        sendAllConnection(convertConnectionNum());

    }

    private void sendAllConnection(String message){
        try {
            TextMessage tm = new TextMessage(message);
            for (WebSocketSession sess : connections) {
                sess.sendMessage(tm);
            }
        }catch (Exception e){

        }
    }

    private String convertConnectionNum() throws Exception{
        ChatVo chatVo = new ChatVo();
        chatVo.setType("num");
        chatVo.setConnection_num(connections.size());

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(chatVo);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        ObjectMapper mapper = new ObjectMapper();
        Chat chat = mapper.readValue(payload,Chat.class);
        chatService.add(chat);

        sendAllConnection(payload);
    }
}


