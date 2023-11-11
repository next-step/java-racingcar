package com.racing.game.entity;

import java.util.List;
import java.util.stream.Collectors;

public class RaceEntry {
    private final List<Car> cars;

    private RaceEntry(List<Car> cars) {
        this.cars = cars;
    }

    public static RaceEntry from(List<Car> cars) {
        return new RaceEntry(cars);
    }

    public List<Car> progressCars() {
        return cars.stream().map(e -> {
            e.incrementProgress();
            return e;
        }).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return cars.stream().map(e -> e.toString().concat("\n")).collect(Collectors.joining());
    }
}
