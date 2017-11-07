package service;

import entity.Chat;

import java.util.List;

public interface ChatService {
    void add(Chat chat);
    List<Chat> getChats();

}
