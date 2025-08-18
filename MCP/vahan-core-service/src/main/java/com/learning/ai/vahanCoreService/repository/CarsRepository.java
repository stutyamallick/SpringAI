package com.learning.ai.vahanCoreService.repository;

import com.learning.ai.vahanCoreService.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CarsRepository extends JpaRepository<Cars, Integer>, JpaSpecificationExecutor<Cars> {
}
