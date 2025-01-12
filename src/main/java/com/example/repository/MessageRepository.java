package com.example.repository;

import com.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
    Message save(Message message);
    List<Message> findAll();
    Message findByMessageId(int messageId);
    Optional<Message> deleteByMessageId(int messageId);
    List<Message> findAllByPostedBy(int accountId);
}
