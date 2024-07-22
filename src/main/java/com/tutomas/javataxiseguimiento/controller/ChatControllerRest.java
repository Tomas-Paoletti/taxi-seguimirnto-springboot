package com.tutomas.javataxiseguimiento.controller;

import com.tutomas.javataxiseguimiento.model.ChatMessage;
import com.tutomas.javataxiseguimiento.repository.ChatMessageRepository;
import com.tutomas.javataxiseguimiento.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ChatControllerRest  {
    @Autowired
    private ChatMessageService chatMessageService;

    @CrossOrigin(origins = "http://localhost:5173") // Reemplaza con el origen de tu aplicación frontend
    @GetMapping("/chats")
    public List<String> getChats() {
        return chatMessageService.getAllSenders();
    }

    @CrossOrigin(origins = "http://localhost:5173") // Reemplaza con el origen de tu aplicación frontend
    @GetMapping("/messages")
    public List<ChatMessage> getMessagesBySender(@RequestParam String sender) {
        return chatMessageService.getMessagesBySender(sender);
    }
}
