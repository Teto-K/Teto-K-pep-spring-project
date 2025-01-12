package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        String txt = message.getMessageText();
        if(txt != "" && txt != null && txt.length() <= 255) {
            messageRepository.createMessage(message);
        } 
        return null;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getAMessage(int id) {
        return messageRepository.findMessageById(id);
    }

    public Optional<Message>deleteMessage(int id) {
        return messageRepository.deleteMessageById(id);
    }

    public Message updateMessage(int id, Message message) {
        String txt = message.getMessageText();
        if(txt != "" && txt != null && txt.length() <= 255) {
            messageRepository.updateMessageById(id, message);
        } 
        return null;
    }

    public List<Message> getAllMessagesById(int accId) {
        return messageRepository.findAllMessagesByAccountId(accId);
    }



}
