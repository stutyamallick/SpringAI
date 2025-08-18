package com.learning.ai.vahanCoreService.model;

import com.learning.ai.vahanCoreService.entity.Cars;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarSearchResponseModel {

    private List<Cars> carsList;
    private boolean status;
}
