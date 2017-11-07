package service;

import dao.ChatDao;
import entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ChatRepository;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatDao chatDao;

    @Autowired
    public ChatServiceImpl(ChatDao chatDao){
        this.chatDao = chatDao;
    }

    @Override
    public void add(Chat chat) {
        chatDao.insert(chat);
    }

    @Override
    public List<Chat> getChats() {
        return chatDao.selectChats();
    }
}
