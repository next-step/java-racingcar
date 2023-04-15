package com.next.step.step3.util;

import com.next.step.step3.domain.Car;
import com.next.step.step3.dto.InputDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {

    private static final int INIT_POSITION = 0;

    private static final String CAR_NAME_DELIMITER = ",";

    private CarsFactory() {
    }

    public static List<Car> createCars(InputDto inputDto) {
        List<String> splitCarNames = splitCarName(inputDto.carNames());
        return splitCarNames.stream()
                .map(carName -> new Car(INIT_POSITION, carName))
                .collect(Collectors.toList());
    }

    private static List<String> splitCarName(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .collect(Collectors.toList());
    }
}
