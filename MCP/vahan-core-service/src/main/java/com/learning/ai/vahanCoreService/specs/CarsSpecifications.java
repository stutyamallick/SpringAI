package com.learning.ai.vahanCoreService.specs;

import com.learning.ai.vahanCoreService.entity.Cars;
import org.springframework.data.jpa.domain.Specification;

public class CarsSpecifications {

    public static Specification<Cars> hasBrand(String brand) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("brand"), brand);
    }

    public static Specification<Cars> hasModel(String model) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("model"), model);
    }

    public static Specification<Cars> hasTransmissionType(String transmissionType) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("transmissionType"), transmissionType);
    }

    public static Specification<Cars> hasFuelType(String fuelType) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("fuelType"), fuelType);
    }

    public static Specification<Cars> hasBodyType(String bodyType) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("bodyType"), bodyType);
    }

    public static Specification<Cars> hasColor(String color) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("color"), color);
    }

    public static Specification<Cars> hasKmDrivenExact(Integer kmDriven) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("kmDriven"), kmDriven);
    }

    public static Specification<Cars> hasKmDrivenLowerLimit(Integer kmDriven) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("kmDriven"), kmDriven);
    }

    public static Specification<Cars> hasKmDrivenHigherLimit(Integer kmDriven) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get("kmDriven"), kmDriven);
    }

    public static Specification<Cars> hasPriceExact(float price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("price"), price);
    }

    public static Specification<Cars> hasPriceLowerLimit(float price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("price"), price);
    }

    public static Specification<Cars> hasPriceHigherLimit(float price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get("price"), price);
    }

    public static Specification<Cars> hasModelYearExact(int modelYear) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("modelYear"), modelYear);
    }

    public static Specification<Cars> hasModelYearLowerLimit(int modelYear) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("modelYear"), modelYear);
    }

    public static Specification<Cars> hasModelYearHigherLimit(int modelYear) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get("modelYear"), modelYear);
    }

    public static Specification<Cars> hasSitingCapacityExact(int sitingCapacity) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("sitingCapacity"), sitingCapacity);
    }

    public static Specification<Cars> hasSitingCapacityLowerLimit(int sitingCapacity) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("sitingCapacity"), sitingCapacity);
    }

    public static Specification<Cars> hasSitingCapacityHigherLimit(int sitingCapacity) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get("sitingCapacity"), sitingCapacity);
    }

}
