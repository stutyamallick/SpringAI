package com.learning.ai.vahanMcpServer;

import com.learning.ai.vahanMcpServer.tools.CarSearchTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class VahanMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VahanMcpServerApplication.class, args);
	}

    @Bean
    public ToolCallbackProvider tools(CarSearchTool carSearchTool){
        return MethodToolCallbackProvider.builder().toolObjects(carSearchTool).build();
    }

    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:8020")
                .build();
    }



}
