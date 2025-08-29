package com.learning.ai.vahanMcpClient.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    ChatClient chatClient;

    @GetMapping("/api/chat")
    public String chat(@RequestParam String prompt) {

        return chatClient.prompt().user(prompt).call().content();
    }

    @GetMapping("/api/v2/chat")
    public List<Object> v2Chat(@RequestParam String prompt) {

        return chatClient.prompt().user(prompt).call().entity(
                new ParameterizedTypeReference<List<Object>>() {
                });
    }

}
