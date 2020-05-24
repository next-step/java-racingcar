package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int END_TRY_COUNT = 0;
    private final List<Car> racingCars;
    private int tryCount;
    private int maxScore;

    public RacingGame(int tryCount, final List<String> names, MovableStrategy movableStrategy) {
        this.tryCount = tryCount;
        racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(new Car(name, movableStrategy));
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public List<Car> move() {
        --tryCount;

        for (Car car : racingCars) {
            maxScore = Math.max(car.move(), maxScore);
        }

        return racingCars;
    }

    public List<Car> getWinners() {
        return racingCars.stream()
                .filter(car -> car.sameScore(maxScore))
                .collect(Collectors.toList());
    }

    public boolean isEndGame() {
        return tryCount == END_TRY_COUNT;
    }
}
