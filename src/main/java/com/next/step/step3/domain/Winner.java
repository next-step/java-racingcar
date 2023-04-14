package com.next.step.step3.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private static final int NOT_FOUND_MAX_POSITION = 0;

    private final int maxPosition;

    private List<Car> carElements;

    public Winner(Cars cars) {
        this.carElements = cars.carElements();
        this.maxPosition = findMaxPosition();
    }

    private int findMaxPosition() {
        List<Car> cars = new ArrayList<>(carElements);
        cars.sort(Comparator.comparingInt(Car::position).reversed());

        return cars.stream()
                .findFirst()
                .map(Car::position)
                .orElse(NOT_FOUND_MAX_POSITION);
    }

    public List<String> getWinnerNames() {
        return carElements.stream()
                .filter(car -> car.position() == maxPosition)
                .map(Car::name)
                .collect(Collectors.toList());
    }
}
