package com.example.repository;

import com.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
    Message createMessage(Message message);
    List<Message> findAllMessages();
    Message findMessageById(int messageId);
    Optional<Message> deleteMessageById(int messageId);
    Message updateMessageById(int messageId, Message message);
    List<Message> findAllMessagesByAccountId(int accountId);
}
