package com.sryoondev.racingcar.step3;

import com.sryoondev.racingcar.step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private MovableChecker movableChecker;
    private final List<Car> cars;
    private final ResultView resultView;

    public Circuit(int carCount, ResultView resultView) {
        this.movableChecker = new MovableChecker();
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.resultView = resultView;
    }

    public int getCarCount() {
        return cars.size();
    }

    public void race() {
        for(Car car : cars) {
            car.race(movableChecker.isMovable());
            resultView.capture(car);
        }
    }
}