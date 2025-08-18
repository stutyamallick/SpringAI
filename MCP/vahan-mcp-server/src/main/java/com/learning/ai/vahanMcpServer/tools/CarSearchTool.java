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
}
