package com.seok.racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    protected Cars(List<Car> cars) {
        this.cars = cars;
    }

    protected Records move() {
        List<Record> records = new ArrayList<>();
        cars.forEach(car -> records.add(car.move()));
        return new Records(records);
    }

    protected Winners getWinners() {
        return new Winners(awarded());
    }

    private List<Winner> awarded() {
        Car fastest =  findFastest();
        return cars
        .stream()
        .filter(car -> car.isTie(fastest))
        .map(Car::awarded)
        .collect(Collectors.toList());
    }

    private Car findFastest() {
        return cars
                .stream()
                .reduce((car1,car2) -> car1.fastThan(car2))
                .get();
    }
}
