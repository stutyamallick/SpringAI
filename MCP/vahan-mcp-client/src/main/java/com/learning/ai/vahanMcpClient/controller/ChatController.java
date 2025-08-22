package com.learning.ai.vahanMcpClient.controller;


import com.learning.ai.vahanMcpClient.model.AddCarRequestModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
public class ChatController {

    @Autowired
    ChatClient chatClient;

    @Autowired
    RestClient restClient;

    @GetMapping("/api/chat")
    public String chat(@RequestParam String prompt) {

        return chatClient.prompt().user(prompt).call().content();
    }

    @PostMapping("/api/car/add")
    public String addCar(@RequestBody AddCarRequestModel addCarRequestModel){

        String validationLogic = """
                Analyze the following request data for potential issues.
                Return just 'OK' if valid. If any issue found return appropriate message.
                None of the values should be empty or null.
                Value for fields brand, model, color can be anything.
                Field modelYear should be numeric only and of 4 characters.
                Field sitingCapacity should be a single character numeric value only with allowed values being 5 or 7.
                Allowed values for Field transmissionType are Automatic and Manual.
                Allowed values for field fuelType are Petrol and Diesel.
                Allowed values for field bodyType sre Hatchback, Sedan, SUV and MUV.
                Field kmDriven can be any numeric value but decimal values are not allowed.
                Field price can be any numeric value. Decimal values are allowed.
                """;

        String prompt = String.format(validationLogic + addCarRequestModel.toString());

        String aiValidation = chatClient.prompt().user(prompt).call().content();

        String response = null;

        assert aiValidation != null;
        if(aiValidation.equalsIgnoreCase("OK")){
            response = restClient.post()
                    .uri("/api/core/addCar")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(addCarRequestModel)
                    .retrieve()
                    .body(String.class);
        }


        return response == null ? aiValidation : response;
    }
}
