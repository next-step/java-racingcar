package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.Movable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> racingCars;
    private int tryCount;
    private static final int END_TRY_COUNT = 0;

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public RacingGame(int tryCount, List<String> names, Movable movable) {
        this.tryCount = tryCount;
        racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(new Car(name, movable));
        }
    }

    public List<Car> move() {
        tryCount = --tryCount;

        for (Car car : racingCars) {
            car.move();
        }

        return racingCars;
    }

    public List<Car> getWinners() {
        int maxScore = racingCars.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();

        return racingCars.stream()
                .filter(car -> car.sameScore(maxScore))
                .collect(Collectors.toList());
    }

    public boolean isNotEndGame() {
        return tryCount != END_TRY_COUNT;
    }
}
