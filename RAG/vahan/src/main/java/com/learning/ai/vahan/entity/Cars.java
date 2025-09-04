package com.learning.ai.vahan.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cars {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "model_year")
    private Integer modelYear;

    @Column(name = "transmission_type")
    private String transmissionType;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "siting_capacity")
    private Integer sitingCapacity;

    @Column(name = "km_driven")
    private Integer kmDriven;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private Float price;
}
