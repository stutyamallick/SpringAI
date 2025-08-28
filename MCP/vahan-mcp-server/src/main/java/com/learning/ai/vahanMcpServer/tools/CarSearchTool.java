package com.learning.ai.vahanMcpServer.tools;

import com.learning.ai.vahanMcpServer.model.CarSearchRequestModel;
import com.learning.ai.vahanMcpServer.model.Cars;
import com.learning.ai.vahanMcpServer.services.CarSearchService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarSearchTool {

    @Autowired
    CarSearchService carSearchService;

    @Tool(
            name = "getAllCars",
            description = """
                    Get all cars that are available to be bought by the customer.
                    Returns a list of cars that users can choose from.
                    These are all the available options.
                    """
    )
    public List<Cars> getAllCars(){

        CarSearchRequestModel requestModel = new CarSearchRequestModel();

        return carSearchService.getCarsFromCoreService(requestModel);
    }

    @Tool(
            name = "getCarsByBrandName",
            description = """
                    Get car options based on the specified brand name that are available to be bought by the customer.
                    Returns a list of cars that users can choose from.
                    These are the available options customers can choose from based on a brand name.
                    """
    )
    public List<Cars> getCarsByBrandName(String brandName){

        CarSearchRequestModel requestModel = new CarSearchRequestModel();
        requestModel.setBrand(brandName);

        return carSearchService.getCarsFromCoreService(requestModel);
    }


    @Tool(
            name = "getCarsByModelName",
            description = """
                    Get car options based on the specified model name that are available to be bought by the customer.
                    Returns a list of cars that users can choose from.
                    These are the available options customers can choose from based on a model name.
                    """
    )
    public List<Cars> getCarByModelName(String modelName){
        CarSearchRequestModel requestModel = new CarSearchRequestModel();
        requestModel.setModel(modelName);

        return carSearchService.getCarsFromCoreService(requestModel);
    }

    @Tool(
            name = "getCarByTransmissionType",
            description = """
                    Get car options based on the specified transmission type of the car
                    that are available to be bought by the customer.
                    Transmission Type are Manual or Automatic for a car.
                    When user wants to find automatic cars or manual cars, use this tool.
                    Returns a list of cars that users can choose from.
                    """
    )
    public List<Cars> getCarByTransmissionType(String transmissionType){
        CarSearchRequestModel requestModel = new CarSearchRequestModel();
        requestModel.setTransmissionType(transmissionType);

        return carSearchService.getCarsFromCoreService(requestModel);
    }

    @Tool(
            name = "getCarsByFuelType",
            description = """
                    Get car options based on the specified fuel type of the car
                    that are available to be bought by the customer.
                    Fuel Type for a car are Petrol or Diesel.
                    When user wants to find petrol cars or diesel cars, use this tool.
                    Returns a list of cars that users can choose from.
                    """
    )
    public List<Cars> getCarsByFuelType(String fuelType){
        CarSearchRequestModel requestModel = new CarSearchRequestModel();
        requestModel.setFuelType(fuelType);

        return carSearchService.getCarsFromCoreService(requestModel);
    }

    @Tool(
            name = "getCarByBodyType",
            description = """
                    Get car options based on the specified body type of the car
                    that are available to be bought by the customer.
                    Body Type for a car are Hatchback, Sedan, SUV or MUV.
                    When user wants to find hatchback cars or Sedan cars or SUV cars or MUV cars, use this tool.
                    Returns a list of cars that users can choose from.
                    """
    )
    public List<Cars> getCarByBodyType(String bodyType){
        CarSearchRequestModel requestModel = new CarSearchRequestModel();
        requestModel.setBodyType(bodyType);

        return carSearchService.getCarsFromCoreService(requestModel);
    }

    @Tool(
            name = "getCarByColor",
            description = """
                    Get car options based on the color of the car.
                    Prompt input could be like red car, blue car etc.
                    Returns a list of cars that users can choose from.
                    """
    )
    public List<Cars> getCarByColor(String color){
        CarSearchRequestModel requestModel = new CarSearchRequestModel();
        requestModel.setColor(color);

        return carSearchService.getCarsFromCoreService(requestModel);
    }


    @Tool(
            name = "getCarByModelYear",
            description = """
                    Get car options based on the model year.
                    Model year, Manufactured year and Make year are same.
                    Users could ask for cars that are of the current year.
                    It returns just the brand name and model name of the car.
                    """
    )
    public Map<String, String> getCarByModelYear(Integer modelYear, boolean isCurrentYear){
        CarSearchRequestModel requestModel = new CarSearchRequestModel();

        requestModel.setModelYear(modelYear);

        if(isCurrentYear)
            requestModel.setModelYear(2025); //Hardcoded current year, change if year changes.

        List<Cars> carsList = carSearchService.getCarsFromCoreService(requestModel);

        Map<String, String> response = new HashMap<>();

        for(Cars cars: carsList){
            response.put(cars.getBrand(), cars.getModel());
        }

        return response;
    }

    @Tool(
            name = "getPriceFromSpecificCarBasedOnId",
            description = """
                    It gets the price of the specific car using the id of the car.
                    It returns just the price of the car.
                    """
    )
    public Float getPriceOfTheCars(Integer id){

        CarSearchRequestModel requestModel = new CarSearchRequestModel();

        List<Cars> carsList = carSearchService.getCarsFromCoreService(requestModel).stream().filter(
                obj -> obj.getId().equals(id)
        ).toList();

        return carsList.get(0).getPrice();

    }

    @Tool(
            name = "getAllBrands",
            description = """
                    It gets all the brands that the customer can choose from.
                    Brand and make of the car is the same thing.
                    It returns a list of string having all the possible brands of the car.
                    """
    )
    public List<String> getAllBrands(){
        List<String> brands = new ArrayList<>();

        CarSearchRequestModel requestModel = new CarSearchRequestModel();

        List<Cars> carsList = carSearchService.getCarsFromCoreService(requestModel);

        for (Cars car: carsList){
            brands.add(car.getBrand());
        }

        return brands;
    }

    @Tool(
            name = "getCheapestCar",
            description = """
                    It get the detail of the car available at the least price.
                    Car available at the least price is also the cheapest car.
                    Return the details of car.
                    """
    )
    public Cars getCheapestCar(){

        CarSearchRequestModel requestModel = new CarSearchRequestModel();

        List<Cars> carsList = carSearchService.getCarsFromCoreService(requestModel);

        carsList.sort((c1, c2) -> Float.compare(c1.getPrice(), c2.getPrice()));

        return carsList.get(0);
    }

    @Tool(
            name = "addNewCar",
            description = """
                    Use this tool to add a new car to the existing list of available cars.
                    User needs to pass all the required information to add a car to database.
                    Brand, Model, model year, transmission type, body type, fuel type, siting capacity,
                    km driven, color and price are to be provided to add a car.
                    If any one is absent, let user know through appropriate error message.
                    -------------------
                    Validations-
                    None of the values should be empty or null.
                    Value for fields brand, model, color can be anything.
                    Field modelYear should be numeric only and of 4 characters.
                    Field sitingCapacity should be a single character numeric value only with allowed values being 5 or 7.
                    Allowed values for Field transmissionType are Automatic and Manual.
                    Allowed values for field fuelType are Petrol and Diesel.
                    Allowed values for field bodyType sre Hatchback, Sedan, SUV and MUV.
                    Field kmDriven can be any numeric value but decimal values are not allowed.
                    Field price can be any numeric value. Decimal values are allowed.
                    If validation fails, let user know through appropriate error message.
                    -------------------
                    Sample prompt will be like-
                    Add a car: red tata altroz, hatchback, with a sitting capacity of 5, km driven is 23000, petrol car, manual transmission, and price is 455000
                    Here color is red, brand is tata, model is altroz and so on..
                    """
    )
    public String addNewCar(
            String brand, String model, Integer modelYear,
            String transmissionType, String fuelType, String bodyType,
            Integer sitingCapacity, Integer kmDriven,
            String color, Float price
    ){
        Cars addCarRequest = new Cars(
                null, brand, model, modelYear, transmissionType,
                fuelType, bodyType, sitingCapacity, kmDriven, color, price
        );

        return carSearchService.addNewCar(addCarRequest);
    }

    /*
    * add a new car: silver color 2018 manual petrol Suzuki Alto. It is a hatchback with siting capacity of 5 people, 43500 km driven and price is 175000
    * */

}
