package com.learning.ai.vahanMcpClient.model;


public class CarRequestModel {

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

    public CarRequestModel() {
    }

    public CarRequestModel(String brand, String model, Integer modelYear, String transmissionType, String fuelType, String bodyType, Integer sitingCapacity, Integer kmDriven, String color, Float price) {
        this.brand = brand;
        this.model = model;
        this.modelYear = modelYear;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
        this.sitingCapacity = sitingCapacity;
        this.kmDriven = kmDriven;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getSitingCapacity() {
        return sitingCapacity;
    }

    public void setSitingCapacity(Integer sitingCapacity) {
        this.sitingCapacity = sitingCapacity;
    }

    public Integer getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(Integer kmDriven) {
        this.kmDriven = kmDriven;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarRequestModel{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                ", transmissionType='" + transmissionType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", sitingCapacity=" + sitingCapacity +
                ", kmDriven=" + kmDriven +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
