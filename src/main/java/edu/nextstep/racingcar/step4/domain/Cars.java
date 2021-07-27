package edu.nextstep.racingcar.step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class Cars extends ArrayList<Car> {

    public void play(int numberOfAttempts) {
        IntStream.range(0, numberOfAttempts).forEach(idx -> attempt(Cars.this));
    }

    private void attempt(Cars cars) {
        cars.forEach(Car::move);
    }

    public List<String> getWinners() {
        int maxDistance = this.stream().mapToInt(Car::getDistance).max().orElse(0);
        return stream()
            .filter(car -> car.getDistance() == maxDistance)
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
