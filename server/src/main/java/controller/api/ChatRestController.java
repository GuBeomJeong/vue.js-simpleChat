package controller.api;

import entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    private ChatService chatService;

    @Autowired
    public ChatRestController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping
    public List<Chat> getList(){
        return chatService.getChats();
    }

    @PostMapping
    public void addChat(@RequestBody Chat chat){
        System.out.println(chat);
        chatService.add(chat);
    }
}
