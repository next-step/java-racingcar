package com.nextlevel.kky.racing.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingExecutor {

    private final List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public CarRacingExecutor(String[] names) {
        carList = new ArrayList();

        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public CarRacingExecutor(List<Car> carList) {
        this.carList = carList;
    }

    public void proceedNextRound() {
        carList.forEach(Car::move);
    }

    public List<Car> getCurrentWinners() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElseThrow();

        return carList.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
