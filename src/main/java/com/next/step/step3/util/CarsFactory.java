package com.next.step.step3.util;

import com.next.step.step3.domain.Car;
import com.next.step.step3.dto.InputDto;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {

    private CarsFactory() {
    }

    public static List<Car> createCars(InputDto inputDto) {
        List<Car> cars = new ArrayList<>();
        for (int creationCount = 0; creationCount < inputDto.numOfCars(); creationCount++) {
            cars.add(new Car());
        }
        return cars;
    }
}
