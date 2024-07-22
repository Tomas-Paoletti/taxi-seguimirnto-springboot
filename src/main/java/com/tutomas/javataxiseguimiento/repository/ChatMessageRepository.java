package com.tutomas.javataxiseguimiento.repository;

import com.tutomas.javataxiseguimiento.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findAll();
    List<ChatMessage> findBySenderOrReceiver(String sender, String receiver);
    List<ChatMessage> findBySenderAndReceiver(String sender, String receiver);

}


