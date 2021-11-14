package com.sryoondev.racingcar.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Circuit {
    private final MovableChecker movableChecker;
    private final List<Car> cars;

    public Circuit(int carCount) {
        this.movableChecker = new MovableChecker();
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
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

    public List<Integer> getRecords() {
        return cars.stream()
                .map(Car::getMoveDistance)
                .collect(Collectors.toList());
    }
}