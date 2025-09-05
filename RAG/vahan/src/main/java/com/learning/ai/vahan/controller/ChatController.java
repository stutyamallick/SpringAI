package com.learning.ai.vahan.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ChatController {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    @Value("classpath:/prompts/rag-prompt.st")
    private Resource ragPromptTemplate;

    public ChatController(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder
                .build();
        this.vectorStore = vectorStore;
    }

    @GetMapping("/api/chat")
    public String chat(@RequestParam String query){

        List<Document> similarDocuments = vectorStore
                .similaritySearch(SearchRequest
                        .builder()
                        .query(query)
                        .topK(4)
                        .build());

        System.out.println(">>> Similar documents: " + similarDocuments);

        String information = similarDocuments.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n"));

        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(ragPromptTemplate);
        Prompt prompt = new Prompt(List.of(
                systemPromptTemplate.createMessage(
                        Map.of("information", information)),
                new UserMessage(query)));

        System.out.println(">>> Prompt: " + prompt.getContents());

        return chatClient.prompt(prompt).call().content();
    }

    /* do you something which is automatic and from Toyota and i don't want any sedan or hatchback*/
}
