package com.sryoondev.racingcar.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Circuit {
    private final MovableChecker movableChecker;
    private final List<Car> cars;

    public Circuit(String[] names) {
        this.movableChecker = new MovableChecker();
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public int getCarCount() {
        return cars.size();
    }

    public void race() {
        for(Car car : cars) {
            car.race(movableChecker.isMovable());
        }
    }

    public Records getRecords() {
        return new Records(cars.stream()
                .map(Car::getMoveDistance)
                .collect(Collectors.toList()));
    }
}