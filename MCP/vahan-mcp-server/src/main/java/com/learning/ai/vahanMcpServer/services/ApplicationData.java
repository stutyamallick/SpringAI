package com.learning.ai.vahanMcpServer.services;

import com.learning.ai.vahanMcpServer.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class ApplicationData {

    public static List<Cars> getApplicationOnLoadData(){

        Cars car1 = new Cars(1,"Tata", "Safari", 2024,"Automatic", "Diesel", "SUV", 7,16000,"Blue", 3500000f);
        Cars car2 = new Cars(2,"Tata", "Nexon", 2022,"Manual", "Petrol", "SUV", 5,36000,"Red", 680000f);
        Cars car3 = new Cars(3,"Tata", "Nexon", 2021,"Automatic", "Petrol", "SUV", 5,41000,"Blue", 760000f);
        Cars car4 = new Cars(4,"Tata", "Tiago", 2018,"Manual", "Petrol", "Hatchback", 5,29000,"Brown", 530000f);
        Cars car5 = new Cars(5,"Tata", "Altroz", 2021,"Manual", "Petrol", "Hatchback", 5,24000,"Grey", 650000f);
        Cars car6 = new Cars(6,"Tata", "Tigor", 2020,"Manual", "Petrol", "Sedan", 5,58000,"Grey", 390000f);
        Cars car7 = new Cars(7,"Suzuki", "Swift", 2024,"Manual", "Petrol", "Hatchback", 5,15000,"White", 680000f);
        Cars car8 = new Cars(8,"Suzuki", "Swift", 2019,"Manual", "Petrol", "Hatchback", 5,63000,"Red", 430000f);
        Cars car9 = new Cars(9,"Suzuki", "Swift", 2023,"Manual", "Petrol", "Hatchback", 5,35000,"Blue", 645000f);
        Cars car10 = new Cars(10, "Suzuki", "Ciaz", 2020,"Automatic", "Diesel", "Sedan", 5,34000,"White", 1200000f);
        Cars car11 = new Cars(11, "Suzuki", "Baleno", 2024,"Automatic", "Petrol", "Hatchback", 5,9000,"Blue", 950000f);
        Cars car12 = new Cars(12, "Suzuki", "Ertiga", 2018,"Manual", "Diesel", "MUV", 7,88000,"White", 1130000f);
        Cars car13 = new Cars(13, "Suzuki", "Ertiga", 2023,"Manual", "Diesel", "MUV", 7,51000,"White", 1420000f);
        Cars car14 = new Cars(14, "Hyundai", "Creta", 2024,"Automatic", "Diesel", "SUV", 5,12000,"White", 1650000f);
        Cars car15 = new Cars(15, "Hyundai", "Creta", 2017,"Automatic", "Petrol", "SUV", 5,65000,"White", 750000f);
        Cars car16 = new Cars(16, "Hyundai", "i20", 2020,"Automatic", "Petrol", "Hatchback", 5,30000,"Grey", 590000f);
        Cars car17 = new Cars(17, "Hyundai", "i10", 2021,"Manual", "Petrol", "Hatchback", 5,32000,"Blue", 480000f);
        Cars car18 = new Cars(18, "Hyundai", "Aura", 2021,"Manual", "Petrol", "Sedan", 5,45000,"White", 610000f);
        Cars car19 = new Cars(19, "Toyota", "Fortuner", 2019,"Automatic", "Diesel", "SUV", 7,60000,"Black", 2800000f);
        Cars car20 = new Cars(20, "Toyota", "Innova", 2025,"Automatic", "Diesel", "MUV", 7,3000,"Blue", 3800000f);
        Cars car21 = new Cars(21, "Toyota", "Innova", 2020,"Automatic", "Petrol", "MUV", 7,55000,"White", 2200000f);
        Cars car22 = new Cars(22, "Toyota", "Innova", 2016,"Manual", "Diesel", "MUV", 7,98000,"White", 1600000f);
        Cars car23 = new Cars(23, "Kia", "Sonnet", 2022,"Manual", "Petrol", "SUV", 5,25000,"Red", 820000f);
        Cars car24 = new Cars(24, "Kia", "Sonnet", 2024,"Automatic", "Petrol", "SUV", 5,12000,"White", 980000f);
        Cars car25 = new Cars(25, "MG", "Hector", 2023,"Automatic", "Diesel", "SUV", 5,23000,"Grey", 1920000f);
        Cars car26 = new Cars(26, "MG", "Astar", 2025,"Automatic", "Petrol", "SUV", 5,6000,"White", 1950000f);
        Cars car27 = new Cars(27, "Mahindra", "Thar", 2025,"Automatic", "Diesel", "SUV", 5,1000,"Black", 1880000f);
        Cars car28 = new Cars(28, "Mahindra", "XUV300", 2023,"Automatic", "Diesel", "SUV", 5,36000,"Red", 860000f);
        Cars car29 = new Cars(29, "Mahindra", "XUV700", 2023,"Automatic", "Diesel", "SUV", 7,62000,"Blue", 1720000f);
        Cars car30 = new Cars(30, "Mahindra", "XUV300", 2022,"Manual", "Petrol", "SUV", 5,45000,"White", 81000f);

        List<Cars> carList = new ArrayList<>();

        carList.add(car1);        carList.add(car2);        carList.add(car3);
        carList.add(car4);        carList.add(car5);        carList.add(car6);
        carList.add(car7);        carList.add(car8);        carList.add(car9);
        carList.add(car10);       carList.add(car11);       carList.add(car12);
        carList.add(car13);       carList.add(car14);       carList.add(car15);
        carList.add(car16);       carList.add(car17);       carList.add(car18);
        carList.add(car19);       carList.add(car20);       carList.add(car21);
        carList.add(car22);       carList.add(car23);       carList.add(car24);
        carList.add(car25);       carList.add(car26);       carList.add(car27);
        carList.add(car28);       carList.add(car29);       carList.add(car30);

        return carList;
    }
}
