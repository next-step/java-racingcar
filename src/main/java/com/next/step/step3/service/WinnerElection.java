package com.next.step.step3.service;

import com.next.step.step3.domain.Car;
import com.next.step.step3.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerElection {

    private static final int NOT_FOUND_MAX_POSITION = 0;

    public static List<String> electionWinners(Cars cars) {
        List<Car> carElements = cars.carElements();
        int maxPosition = findMaxPosition(carElements);

        return carElements.stream()
                .filter(car -> car.position() == maxPosition)
                .map(Car::name)
                .collect(Collectors.toList());
    }

    private static int findMaxPosition(List<Car> carElements) {
        return carElements.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(NOT_FOUND_MAX_POSITION);
    }
}
