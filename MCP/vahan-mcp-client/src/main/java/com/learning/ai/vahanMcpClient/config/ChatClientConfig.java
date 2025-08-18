package com.learning.ai.vahanMcpClient.config;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {


    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools){
        return chatClientBuilder
                .defaultSystem("Please prioritise context information for answering questions")
                .defaultToolCallbacks(tools)
                .build();
    }
}
