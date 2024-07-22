package com.tutomas.javataxiseguimiento.controller;

import com.tutomas.javataxiseguimiento.inicial.CommandLineInit;
import com.tutomas.javataxiseguimiento.model.ChatMessage;
import com.tutomas.javataxiseguimiento.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;


    @MessageMapping("/chat.sendMessage")
    @SendTo("/chat/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }


}
