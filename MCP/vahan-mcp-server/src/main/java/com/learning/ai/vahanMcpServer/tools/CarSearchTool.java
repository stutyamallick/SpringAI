package com.learning.ai.vahanMcpServer.tools;

import com.learning.ai.vahanMcpServer.model.CarSearchRequestModel;
import com.learning.ai.vahanMcpServer.model.Cars;
import com.learning.ai.vahanMcpServer.services.CarSearchService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarSearchTool {

    @Tool(
            name = "getAllCars",
            description = """
                    Get all cars that are available to be bought by the customer.
                    Returns a list of cars that users can choose from.
                    These are all the available options.
                    """
    )
    public List<Cars> getCars(){

        CarSearchRequestModel requestModel = new CarSearchRequestModel();

        return CarSearchService.getCarListBasedOnSearchCriteria(requestModel);
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

        return CarSearchService.getCarListBasedOnSearchCriteria(requestModel);
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

        return CarSearchService.getCarListBasedOnSearchCriteria(requestModel);
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

        return CarSearchService.getCarListBasedOnSearchCriteria(requestModel);
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

        return CarSearchService.getCarListBasedOnSearchCriteria(requestModel);
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

        return CarSearchService.getCarListBasedOnSearchCriteria(requestModel);
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

        return CarSearchService.getCarListBasedOnSearchCriteria(requestModel);
    }


    @Tool(
            name = "getCarByModelYear",
            description = """
                    Get car options based on the model year.
                    Model year, Manufactured year and Make year are same.
                    Users could ask for cars that are of the current year.
                    """
    )
    public List<Cars> getCarsOfCurrentYear(Integer modelYear, boolean isCurrentYear){
        CarSearchRequestModel requestModel = new CarSearchRequestModel();

        requestModel.setModelYear(modelYear);

        if(isCurrentYear)
            requestModel.setModelYear(2025); //Hardcoded current year, change if year changes.

        return CarSearchService.getCarListBasedOnSearchCriteria(requestModel);
    }
}
