package com.learning.ai.vahanMcpServer.services;

import com.learning.ai.vahanMcpServer.model.CarSearchRequestModel;
import com.learning.ai.vahanMcpServer.model.Cars;

import java.util.List;

public class CarSearchService {

    public static List<Cars> getCarListBasedOnSearchCriteria(CarSearchRequestModel requestModel){
        List<Cars> responseList = ApplicationData.getApplicationOnLoadData();

        if(requestModel != null && requestModel.getBrand() != null){
            responseList = responseList.stream().filter(
                    obj -> obj.getBrand().equalsIgnoreCase(requestModel.getBrand())).toList();
        }
        return responseList;
    }
}
