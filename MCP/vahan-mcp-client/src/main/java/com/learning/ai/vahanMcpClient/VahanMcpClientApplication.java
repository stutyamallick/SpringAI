package com.learning.ai.vahanMcpClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class VahanMcpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(VahanMcpClientApplication.class, args);
	}

    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:8020")
                .build();
    }
}
