package com.learning.ai.vahan.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardingPassSummarizerModel {

    private String pnr;
    private String travellerName;
    private String airline;
    private String originatingCity;
    private String startTime;
    private String destinationCity;
    private String landingTime;
    private String travelDate;
    private String seatNumber;
    private String meal;
    private Integer checkInAllowedInKg;
    private Integer cabinAllowedInKg;
    private Float ticketPrice;
    private String paymentVia;
    private Float savingViaCoupon;
    private String couponUsed;

}
