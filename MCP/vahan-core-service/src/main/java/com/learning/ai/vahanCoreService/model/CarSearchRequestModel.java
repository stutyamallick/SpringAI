package com.learning.ai.vahanCoreService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchRequestModel {

    private String brand;
    private String model;

    private Integer modelYear;
    private String modelYearValueConstraint;

    private String transmissionType;
    private String fuelType;
    private String bodyType;

    private Integer sitingCapacity;
    private String sitingCapacityValueConstraint;

    private Integer kmDriven;
    private String kmDrivenValueConstraint;

    private String color;

    private Float price;
    private String priceValueConstraint;
}
