package handler;

import entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import service.ChatService;

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
        connections.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        connections.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        TextMessage echoMessage = new TextMessage(message.getPayload());
        Chat chat = new Chat();
        chat.setData(message.getPayload());
        chatService.add(chat);
        for(WebSocketSession sess : connections){
            sess.sendMessage(echoMessage);
        }


    }
}


