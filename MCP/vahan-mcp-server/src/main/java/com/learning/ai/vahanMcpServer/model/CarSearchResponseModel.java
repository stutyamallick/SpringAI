package com.learning.ai.vahanMcpServer.model;

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

    private List<com.learning.ai.vahanMcpServer.model.Cars> carsList;
    private boolean status;
}
