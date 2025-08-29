package com.learning.ai.vahan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
