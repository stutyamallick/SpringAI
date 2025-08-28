package com.learning.ai.vahanCoreService.controller;

import com.learning.ai.vahanCoreService.entity.Cars;
import com.learning.ai.vahanCoreService.model.CarSearchRequestModel;
import com.learning.ai.vahanCoreService.model.CarSearchResponseModel;
import com.learning.ai.vahanCoreService.repository.CarsRepository;
import com.learning.ai.vahanCoreService.specs.CarsSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    CarsRepository carsRepository;

    @PostMapping("/api/core/getCars")
    public CarSearchResponseModel getCarsBasedOnSearchCriteria(@RequestBody CarSearchRequestModel request){
        Specification<Cars> spec = Specification.where(null);

        if(request.getBrand() != null)
            spec = spec.and(CarsSpecifications.hasBrand(request.getBrand()));

        if(request.getModel() != null)
            spec = spec.and(CarsSpecifications.hasModel(request.getModel()));

        if(request.getTransmissionType() != null)
            spec = spec.and(CarsSpecifications.hasTransmissionType(request.getTransmissionType()));

        if(request.getFuelType() != null)
            spec = spec.and(CarsSpecifications.hasFuelType(request.getFuelType()));

        if(request.getBodyType() != null)
            spec = spec.and(CarsSpecifications.hasBodyType(request.getBodyType()));

        if(request.getColor() != null)
            spec = spec.and(CarsSpecifications.hasColor(request.getColor()));

        if(request.getBrand() != null)
            spec = spec.and(CarsSpecifications.hasBrand(request.getBrand()));

        if(request.getBrand() != null)
            spec = spec.and(CarsSpecifications.hasBrand(request.getBrand()));

        if(request.getKmDriven() != null) {

            if(request.getKmDrivenValueConstraint() != null && request.getKmDrivenValueConstraint().equalsIgnoreCase("less"))
                spec = spec.and(CarsSpecifications.hasKmDrivenHigherLimit(request.getKmDriven()));

            else if(request.getKmDrivenValueConstraint() != null && request.getKmDrivenValueConstraint().equalsIgnoreCase("more"))
                spec = spec.and(CarsSpecifications.hasKmDrivenLowerLimit(request.getKmDriven()));
            else
                spec = spec.and(CarsSpecifications.hasKmDrivenExact(request.getKmDriven()));
        }

        if(request.getPrice() != null) {
            if(request.getPriceValueConstraint() != null && request.getPriceValueConstraint().equalsIgnoreCase("less"))
                spec = spec.and(CarsSpecifications.hasPriceHigherLimit(request.getPrice()));

            else if(request.getPriceValueConstraint() != null && request.getPriceValueConstraint().equalsIgnoreCase("more"))
                spec = spec.and(CarsSpecifications.hasPriceLowerLimit(request.getPrice()));

            else
                spec = spec.and(CarsSpecifications.hasPriceExact(request.getPrice()));
        }

        if(request.getModelYear() != null) {

            if(request.getModelYearValueConstraint() != null && request.getModelYearValueConstraint().equalsIgnoreCase("less"))
                spec = spec.and(CarsSpecifications.hasModelYearHigherLimit(request.getModelYear()));

            else if(request.getModelYearValueConstraint() != null && request.getModelYearValueConstraint().equalsIgnoreCase("more"))
                spec = spec.and(CarsSpecifications.hasModelYearLowerLimit(request.getModelYear()));

            else
                spec = spec.and(CarsSpecifications.hasModelYearExact(request.getModelYear()));
        }

        if(request.getSitingCapacity() != null) {

            if(request.getSitingCapacityValueConstraint() != null && request.getSitingCapacityValueConstraint().equalsIgnoreCase("less"))
                spec = spec.and(CarsSpecifications.hasSitingCapacityHigherLimit(request.getSitingCapacity()));

            else if(request.getSitingCapacityValueConstraint() != null && request.getSitingCapacityValueConstraint().equalsIgnoreCase("more"))
                spec = spec.and(CarsSpecifications.hasSitingCapacityLowerLimit(request.getSitingCapacity()));

            else
                spec = spec.and(CarsSpecifications.hasSitingCapacityExact(request.getSitingCapacity()));
        }

        CarSearchResponseModel response = new CarSearchResponseModel();
        List<Cars> cars = new ArrayList<>();

        try{
            cars = carsRepository.findAll(spec);
            response.setCarsList(cars);
            response.setStatus(true);
        } catch (RuntimeException e) {
            response.setCarsList(Collections.emptyList());
            response.setStatus(false);
        }

        return response;
    }

    @GetMapping("/api/core/initData")
    public String saveData(){

        Cars car2 = new Cars(null,"Tata", "Safari", 2024,"Automatic", "Diesel", "SUV", 7,16000,"Blue", 3500000f);
        Cars car3 = new Cars(null,"Tata", "Nexon", 2022,"Manual", "Petrol", "SUV", 5,36000,"Red", 680000f);
        Cars car4 = new Cars(null,"Tata", "Nexon", 2021,"Automatic", "Petrol", "SUV", 5,41000,"Blue", 760000f);
        Cars car5 = new Cars(null,"Tata", "Tiago", 2018,"Manual", "Petrol", "Hatchback", 5,29000,"Brown", 530000f);
        Cars car6 = new Cars(null,"Tata", "Altroz", 2021,"Manual", "Petrol", "Hatchback", 5,24000,"Grey", 650000f);
        Cars car7 = new Cars(null,"Tata", "Tigor", 2020,"Manual", "Petrol", "Sedan", 5,58000,"Grey", 390000f);
        Cars car8 = new Cars(null,"Suzuki", "Swift", 2024,"Manual", "Petrol", "Hatchback", 5,15000,"White", 680000f);
        Cars car9 = new Cars(null,"Suzuki", "Swift", 2019,"Manual", "Petrol", "Hatchback", 5,63000,"Red", 430000f);
        Cars car10 = new Cars(null,"Suzuki", "Swift", 2023,"Manual", "Petrol", "Hatchback", 5,35000,"Blue", 645000f);
        Cars car11 = new Cars(null, "Suzuki", "Ciaz", 2020,"Automatic", "Diesel", "Sedan", 5,34000,"White", 1200000f);
        Cars car12 = new Cars(null, "Suzuki", "Baleno", 2024,"Automatic", "Petrol", "Hatchback", 5,9000,"Blue", 950000f);
        Cars car13 = new Cars(null, "Suzuki", "Ertiga", 2018,"Manual", "Diesel", "MUV", 7,88000,"White", 1130000f);
        Cars car14 = new Cars(null, "Suzuki", "Ertiga", 2023,"Manual", "Diesel", "MUV", 7,51000,"White", 1420000f);
        Cars car15 = new Cars(null, "Hyundai", "Creta", 2024,"Automatic", "Diesel", "SUV", 5,12000,"White", 1650000f);
        Cars car16 = new Cars(null, "Hyundai", "Creta", 2017,"Automatic", "Petrol", "SUV", 5,65000,"White", 750000f);
        Cars car17 = new Cars(null, "Hyundai", "i20", 2020,"Automatic", "Petrol", "Hatchback", 5,30000,"Grey", 590000f);
        Cars car18 = new Cars(null, "Hyundai", "i10", 2021,"Manual", "Petrol", "Hatchback", 5,32000,"Blue", 480000f);
        Cars car19 = new Cars(null, "Hyundai", "Aura", 2021,"Manual", "Petrol", "Sedan", 5,45000,"White", 610000f);
        Cars car20 = new Cars(null, "Toyota", "Fortuner", 2019,"Automatic", "Diesel", "SUV", 7,60000,"Black", 2800000f);
        Cars car21 = new Cars(null, "Toyota", "Innova", 2025,"Automatic", "Diesel", "MUV", 7,3000,"Blue", 3800000f);
        Cars car22 = new Cars(null, "Toyota", "Innova", 2020,"Automatic", "Petrol", "MUV", 7,55000,"White", 2200000f);
        Cars car23 = new Cars(null, "Toyota", "Innova", 2016,"Manual", "Diesel", "MUV", 7,98000,"White", 1600000f);
        Cars car24 = new Cars(null, "Kia", "Sonnet", 2022,"Manual", "Petrol", "SUV", 5,25000,"Red", 820000f);
        Cars car25 = new Cars(null, "Kia", "Sonnet", 2024,"Automatic", "Petrol", "SUV", 5,12000,"White", 980000f);
        Cars car26 = new Cars(null, "MG", "Hector", 2023,"Automatic", "Diesel", "SUV", 5,23000,"Grey", 1920000f);
        Cars car27 = new Cars(null, "MG", "Astar", 2025,"Automatic", "Petrol", "SUV", 5,6000,"White", 1950000f);
        Cars car28 = new Cars(null, "Mahindra", "Thar", 2025,"Automatic", "Diesel", "SUV", 5,1000,"Black", 1880000f);
        Cars car29 = new Cars(null, "Mahindra", "XUV300", 2023,"Automatic", "Diesel", "SUV", 5,36000,"Red", 860000f);
        Cars car30 = new Cars(null, "Mahindra", "XUV700", 2023,"Automatic", "Diesel", "SUV", 7,62000,"Blue", 1720000f);
        Cars car31 = new Cars(null, "Mahindra", "XUV300", 2022,"Manual", "Petrol", "SUV", 5,45000,"White", 810000f);

        List<Cars> carList = new ArrayList<>();

        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        carList.add(car7);
        carList.add(car8);
        carList.add(car9);
        carList.add(car10);
        carList.add(car11);
        carList.add(car12);
        carList.add(car13);
        carList.add(car14);
        carList.add(car15);
        carList.add(car16);
        carList.add(car17);
        carList.add(car18);
        carList.add(car19);
        carList.add(car20);
        carList.add(car21);
        carList.add(car22);
        carList.add(car23);
        carList.add(car24);
        carList.add(car25);
        carList.add(car26);
        carList.add(car27);
        carList.add(car28);
        carList.add(car29);
        carList.add(car30);
        carList.add(car31);

        carsRepository.saveAll(carList);

        return "SAVED";
    }

    @PostMapping("/api/core/addNewCar")
    public String addNewCar(@RequestBody Cars cars){
        carsRepository.save(cars);
        return "Saved";
    }
}
