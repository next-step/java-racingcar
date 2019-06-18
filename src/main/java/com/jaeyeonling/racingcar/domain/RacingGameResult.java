package com.jaeyeonling.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {

    private final int victorPosition;
    private final List<Car> victors;

    RacingGameResult(final Participants participants) {
        victorPosition = participants.toList()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.DEFAULT_POSITION);

        victors = participants.toList()
                .stream()
                .filter(car -> car.isMatchPosition(victorPosition))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getVictors() {
        return victors;
    }
}
