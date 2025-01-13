package com.example.service;

import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Message createMessage(Message message) {
        if(accountRepository.findByAccountId(message.getPostedBy()) == null) {
            return null;
        }
        String txt = message.getMessageText();
        if(txt != "" && txt != null && txt.length() <= 255) {
            return messageRepository.save(message);
        } 
        return null;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getAMessage(int id) {
        return messageRepository.findByMessageId(id);
    }

    @Transactional
    public int deleteMessage(int id) {
        if(messageRepository.findByMessageId(id) != null) {
            messageRepository.deleteByMessageId(id);
            return 1;
        } else {
            return 0;
        }
    }

    public int updateMessage(int id, String message_text) {
        Message updMessage = messageRepository.findByMessageId(id);
        if(updMessage == null) {
            return 0;
        }
        String fixedText = message_text.subSequence(17, message_text.length() - 2).toString();
        if(fixedText.length() != 0 && fixedText != null && fixedText.length() <= 255) {
            updMessage.setMessageText(fixedText);
            messageRepository.save(updMessage);
            return 1;
        } 
        return 0;
    }

    public List<Message> getAllMessagesById(int accId) {
        return messageRepository.findAllByPostedBy(accId);
    }
}
