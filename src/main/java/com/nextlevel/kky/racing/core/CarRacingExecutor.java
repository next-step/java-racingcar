package com.nextlevel.kky.racing.core;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingExecutor {

    private final List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public CarRacingExecutor(List<Car> carList) {
        this.carList = carList;
    }

    public void proceedNextRound() {
        carList.forEach(Car::move);
    }

    public List<String> getCurrentWinners() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElseThrow();

        return carList.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
