package com.nextstep.racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public Cars move(GasStation gasStation) {
        List<Car> movedCars = this.cars.stream()
                .map(car -> car.move(gasStation))
                .collect(Collectors.toList());

        return new Cars(movedCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
