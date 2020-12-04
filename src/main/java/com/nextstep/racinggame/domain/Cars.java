package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidDistanceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars move(final MovePolicy movePolicy) {
        List<Car> movedCars = this.cars.stream()
                .map(car -> car.move(movePolicy))
                .collect(Collectors.toList());

        return new Cars(movedCars);
    }

    public List<Car> calculateMostMovedCars() {
        return cars.stream()
                .filter(car -> car.isMovedAmount(calculateLongestDistance()))
                .collect(Collectors.toList());
    }

    private Integer calculateLongestDistance() {
        return this.cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new InvalidDistanceException("가장 멀리 이동한 차량이 존재하지 않습니다."));
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
