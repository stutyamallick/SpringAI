package com.learning.ai.vahanCoreService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCarRequestModel {

    private String brand;
    private String model;
    private Integer modelYear;
    private String transmissionType;
    private String fuelType;
    private String bodyType;
    private Integer sitingCapacity;
    private Integer kmDriven;
    private String color;
    private Float price;

}
