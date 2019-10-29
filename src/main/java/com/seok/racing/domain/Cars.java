package com.seok.racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.stream().forEach(Car::move);
    }

    public List<String> getWinners() {
        int max = stream()
            .max(Comparator.comparing(car -> car.getRecord().getTotalDistance()))
            .map(car -> car.getRecord().getTotalDistance())
            .get();
        return stream()
            .filter(car -> car.getRecord().getTotalDistance() == max)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}
