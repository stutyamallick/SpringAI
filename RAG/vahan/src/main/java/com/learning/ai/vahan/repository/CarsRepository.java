package com.learning.ai.vahan.repository;

import com.learning.ai.vahan.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarsRepository extends JpaRepository<Cars, Integer> {
}
