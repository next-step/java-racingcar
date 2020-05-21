package com.kimdahyeee.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> racingCars;

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public RacingGame(List<String> names) {
        racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(new Car(name));
        }
    }

    public void move() {
        for (Car car : racingCars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        int maxScore = racingCars.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();

        return racingCars.stream()
                .filter(car -> car.getPosition() == maxScore)
                .collect(Collectors.toList());
    }
}
