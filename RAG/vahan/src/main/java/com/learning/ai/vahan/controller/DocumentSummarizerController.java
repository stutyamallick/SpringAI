package com.learning.ai.vahan.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;

@RestController
public class DocumentSummarizerController {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    @Value("classpath:/documents/Stutya_Mallick_CV.pdf")
    private Resource resume;


    public DocumentSummarizerController(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
        this.vectorStore = vectorStore;
    }

    @GetMapping("/api/doc")
    public String summarizeDocument(@RequestParam String query){

        var pdfReader = new TikaDocumentReader(resume);

        TextSplitter textSplitter = new TokenTextSplitter();

        vectorStore.accept(textSplitter.apply(pdfReader.get()));

        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}
