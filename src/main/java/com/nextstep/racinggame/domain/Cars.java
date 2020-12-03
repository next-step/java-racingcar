package com.nextstep.racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars of(final int carDemand) {
        return new Cars(
                IntStream.range(0, carDemand)
                .mapToObj(number -> Car.of())
                .collect(Collectors.toList())
        );
    }

    public int size() {
        return this.cars.size();
    }
}
