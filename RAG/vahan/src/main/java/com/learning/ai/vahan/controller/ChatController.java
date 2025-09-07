package com.learning.ai.vahan.controller;

import com.learning.ai.vahan.service.RagService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;
    private final RagService ragService;

    public ChatController(ChatClient.Builder chatClientBuilder, RagService ragService) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        You are an advisor to find cars
                        and fetch details from the PDF based on the context provided.
                        For Everything else just say 'I Don't Know'. Don't use your trained data.
                        """)
                .build();
        this.ragService = ragService;
    }

    @GetMapping("/api/chat")
    public String chat(@RequestParam String query){

        var prompt = ragService.getAugumentedPrompt(query);

        return chatClient.prompt(prompt).call().content();
    }

}
