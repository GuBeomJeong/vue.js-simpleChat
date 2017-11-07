package dao;

import entity.Chat;

import java.util.List;

public interface ChatDao {

    void insert(Chat chat);
    List<Chat> selectChats();
}
