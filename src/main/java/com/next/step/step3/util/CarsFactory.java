package com.next.step.step3.util;

import com.next.step.step3.domain.Car;
import com.next.step.step3.dto.InputDto;

import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {

    private static final int INIT_POSITION = 0;

    private CarsFactory() {
    }

    public static List<Car> createCars(InputDto inputDto) {
        return inputDto.carNames().stream()
                .map(carName -> new Car(INIT_POSITION, carName))
                .collect(Collectors.toList());
    }
}
