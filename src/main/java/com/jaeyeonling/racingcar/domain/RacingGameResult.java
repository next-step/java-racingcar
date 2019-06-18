package com.jaeyeonling.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {

    private final int victorPosition;
    private final List<Car> victors;

    RacingGameResult(final List<Car> cars) {
        victorPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.DEFAULT_POSITION);

        victors = cars.stream()
                .filter(car -> car.isMatchPosition(victorPosition))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getVictors() {
        return victors;
    }
}
