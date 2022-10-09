package com.nextlevel.kky.racing.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingExecutor {

    public List<Car> carList;

    public CarRacingExecutor(int carCount) {
        carList = new ArrayList();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public CarRacingExecutor(String names[]) {
        carList = new ArrayList();

        for (String name : names) {
            carList.add(new Car(name));
        }
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
