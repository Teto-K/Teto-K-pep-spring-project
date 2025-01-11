package com.example.service;

import com.example.entity.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    
    private List<Message> messageLit = new ArrayList<>();

    private AccountService accountService;
    /*
    @Autowired
    public MessageService(AccountService accountService) {
        this.accountService = accountService;
    }*/

    public Message createMessage(Message message) {
        
        return null;
    }

    public List<Message> getAllMessages() {

        return null;
    }

    public Message getAMessage(int id) {

        return null;
    }

    public Message deleteMessage(int id) {

        return null;
    }

    public Message updateMessage(int id, Message message) {

        return null;
    }

    public List<Message> getAllMessagesById(int accId) {

        return null;
    }



}
