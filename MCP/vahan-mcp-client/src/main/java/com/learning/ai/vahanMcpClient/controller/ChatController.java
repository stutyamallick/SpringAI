package com.learning.ai.vahanMcpClient.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    ChatClient chatClient;

    @GetMapping("/api/chat")
    public String chat(@RequestParam String prompt) {

        return chatClient.prompt().user(prompt).call().content();
    }
}
