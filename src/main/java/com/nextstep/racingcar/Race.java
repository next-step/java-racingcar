package com.nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Race {
    private int moveLimit;
    private List<Car> cars = new ArrayList<>();

    public Race(int carCount, int moveLimit, Supplier<Integer> numberGenerator) {
        this.moveLimit = moveLimit;
        for ( int ix = 0 ; ix < carCount ; ix ++ ) {
            cars.add(new Car(numberGenerator));
        }
    }

    public List<Car> moveAndGet() {
        for (Car car : cars) {
            car.tryMove();
        }
        return cars;
    }

    public boolean isNotFinished() {
        boolean isNotFinished = true;
        for ( Car car : cars) {
            isNotFinished = isNotFinished && car.isNotFinished(moveLimit);
        }
        return isNotFinished;
    }
}
