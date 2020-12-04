package com.nextstep.racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public int size() {
        return this.cars.size();
    }

    public Cars move(final MovePolicy movePolicy) {
        List<Car> movedCars = this.cars.stream()
                .map(car -> car.move(movePolicy))
                .collect(Collectors.toList());

        return new Cars(movedCars);
    }

    public CurrentDistance calculateCurrentDistance() {
        List<Integer> distanceValues = this.cars.stream()
                .map(Car::getDistance)
                .collect(Collectors.toList());

        return new CurrentDistance(distanceValues);
    }

    public List<Car> getCars() {
        return new ArrayList<>(this.cars);
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
