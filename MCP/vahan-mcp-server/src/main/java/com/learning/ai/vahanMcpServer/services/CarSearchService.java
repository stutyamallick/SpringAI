package com.learning.ai.vahanMcpServer.services;

import com.learning.ai.vahanMcpServer.model.CarSearchRequestModel;
import com.learning.ai.vahanMcpServer.model.CarSearchResponseModel;
import com.learning.ai.vahanMcpServer.model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CarSearchService {

    @Autowired
    RestClient restClient;

    public List<Cars> getCarsFromCoreService(CarSearchRequestModel requestModel){

        CarSearchResponseModel response = restClient.post()
                .uri("/api/core/getCars")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestModel)
                .retrieve()
                .body(CarSearchResponseModel.class);

        assert response != null;
        return response.getCarsList();
    }

}
