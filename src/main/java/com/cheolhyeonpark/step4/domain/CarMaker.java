package com.cheolhyeonpark.step4.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarMaker {

    public static final int CAR_START_POSITION = 0;
    public static final String SEPARATOR = ",";

    public List<Car> getCars(String namesOfCars) {
        String[] names = getSeparateNames(namesOfCars);
        return createCarInstance(names);
    }

    private String[] getSeparateNames(String namesOfCars) {
        return namesOfCars.split(SEPARATOR);
    }

    private List<Car> createCarInstance(String[] names) {
        validate(names);
        return Arrays.stream(names).map(name -> new Car(name, CAR_START_POSITION)).collect(Collectors.toList());
    }

    private void validate(String[] names) {
        Arrays.stream(names).filter(StringUtils::isEmpty).findFirst().ifPresent((name) -> {
            throw new IllegalArgumentException("Car name is empty. Please check your car names.");
        });
    }
}
