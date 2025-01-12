package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    /*@Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }*/

    public Message createMessage(Message message) {
        String txt = message.getMessageText();
        if(txt != "" && txt != null && txt.length() <= 255) {
            messageRepository.save(message);
        } 
        return null;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getAMessage(int id) {
        return messageRepository.findByMessageId(id);
    }

    public int deleteMessage(int id) {
        if(messageRepository.deleteByMessageId(id) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    public int updateMessage(int id, String message_text) {
        if(message_text != "" && message_text != null && message_text.length() <= 255) {
            Message updMessage = messageRepository.findByMessageId(id);
            updMessage.setMessageText(message_text);
            messageRepository.save(updMessage);
            return 1;
        } 
        return 0;
    }

    public List<Message> getAllMessagesById(int accId) {
        return messageRepository.findAllByPostedBy(accId);
    }
}
