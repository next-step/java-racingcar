package com.racing.game.entity;

import com.racing.game.dto.Winners;
import java.util.ArrayList;
import java.util.Collections;
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
        List<Car> carList = cars.stream().map(e -> Car.of(e.name(), e.progress())).collect(Collectors.toList());
        return carList.stream().map(e -> {
            e.incrementProgress();
            return e;
        }).collect(Collectors.toList());
    }

    public Winners winners() {
        List<Car> result = new ArrayList<>(cars);
        result.sort(Collections.reverseOrder());

        Car max = result.get(0);
        return Winners.from(result.stream().filter(e -> e.isSame(max.progress()) || e.isAheadFrom(max.progress())).map(
                Car::name).collect(
                Collectors.toList()));
    }

    @Override
    public String toString() {
        return cars.stream().map(e -> e.toString().concat(System.lineSeparator())).collect(Collectors.joining());
    }
}
