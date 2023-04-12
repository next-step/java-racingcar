package com.next.step.step3.util;

import com.next.step.step3.domain.Car;
import com.next.step.step3.dto.InputDto;

import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {

    private CarsFactory() {
    }

    public static List<Car> createCars(InputDto inputDto) {
        return inputDto.carNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
