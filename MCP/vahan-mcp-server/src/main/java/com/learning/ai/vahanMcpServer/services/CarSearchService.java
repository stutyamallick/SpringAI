package com.learning.ai.vahanMcpServer.services;

import com.learning.ai.vahanMcpServer.model.CarSearchRequestModel;
import com.learning.ai.vahanMcpServer.model.Cars;

import java.util.List;

public class CarSearchService {

    public static List<Cars> getCarListBasedOnSearchCriteria(CarSearchRequestModel requestModel){
        List<Cars> responseList = ApplicationData.getApplicationOnLoadData();

        if(requestModel != null){
            if(requestModel.getBrand() != null)
                responseList = responseList.stream().filter(
                        obj -> obj.getBrand().equalsIgnoreCase(requestModel.getBrand())).toList();

            if(requestModel.getModel() != null)
                responseList = responseList.stream().filter(
                        obj -> obj.getModel().equalsIgnoreCase(requestModel.getModel())).toList();

            if(requestModel.getTransmissionType() != null)
                responseList = responseList.stream().filter(
                        obj -> obj.getTransmissionType().equalsIgnoreCase(requestModel.getTransmissionType())).toList();

            if(requestModel.getFuelType() != null)
                responseList = responseList.stream().filter(
                        obj -> obj.getFuelType().equalsIgnoreCase(requestModel.getFuelType())).toList();

            if(requestModel.getBodyType() != null)
                responseList = responseList.stream().filter(
                        obj -> obj.getBodyType().equalsIgnoreCase(requestModel.getBodyType())).toList();

            if(requestModel.getColor() != null)
                responseList = responseList.stream().filter(
                        obj -> obj.getColor().equalsIgnoreCase(requestModel.getColor())).toList();

            if(requestModel.getModelYear() != null)
                responseList = responseList.stream().filter(
                        obj -> obj.getModelYear().compareTo(requestModel.getModelYear()) == 0 ).toList();
        }

        return responseList;
    }
}
