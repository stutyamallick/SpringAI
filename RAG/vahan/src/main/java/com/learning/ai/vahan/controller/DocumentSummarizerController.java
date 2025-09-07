package com.learning.ai.vahan.controller;

import com.learning.ai.vahan.models.BoardingPassSummarizerModel;
import com.learning.ai.vahan.service.RagService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentSummarizerController {

    private final ChatClient chatClient;
    private final RagService ragService;

    public DocumentSummarizerController(ChatClient.Builder chatClientBuilder, RagService ragService) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        You are an advisor to find cars
                        and fetch details from the PDF based on the context provided.
                        For Everything else just say 'I Don't Know'. Don't use your trained data.
                        """)
                .build();
        this.ragService = ragService;
    }

    @GetMapping("/api/summarize")
    public BoardingPassSummarizerModel summarizeDocument(@RequestParam String pnr){

        String createdPromptFromPnr = "For PNR: " + pnr;

        String queryToSummarizeDocument = createdPromptFromPnr + """
                  find the following:
                 the pnr of the journey, just the pnr value. the field to store its value to is->  pnr
                 the Airline that will operate this flight, just the airline name nothing else. the field to store its value to is->  airline
                 Also Find the traveller name, just the name. the field to store its value to is->  travellerName
                 Just the Originating city, the field to store its value to is->  originatingCity
                 just the destination city, the field to store its value to is->  destinationCity
                 just the flight start time in 24 hr format, don't mention hr at the end, the field to store its value to is->  startTime
                 just the flight landing time in 24 hr format, don't mention hr at the end, the field to store its value to is->  landingTime
                 just the travel date which should include its day, date. the field to store its value to is->  travelDate
                 If there is seat number allotted then mention the seta number. the field to store its value to is->  seatNumber
                 If there is meal opted, mention the meal. the field to store its value to is->  meal
                 State the price at which the booking was made, just the price. the field to store its value to is->  ticketPrice
                 Tell me the coupon code that was used, the field to store its value to is->  couponUsed
                 the amount that was saved through the coupon code, the field to store its value to is->  savingViaCoupon
                 Give me just the value in kg the check in baggage allowed, the field to store its value to is->  checkInAllowedInKg
                 just the value in kg for the cabin bag, the field to store its value to is->  cabinAllowedInKg
                 just the method how the payment was made for the ticket, the field to store its value is->paymentVia
                """;

        var prompt = ragService.getAugumentedPrompt(queryToSummarizeDocument);

        return chatClient.prompt(prompt).call().entity(BoardingPassSummarizerModel.class);
    }
}
