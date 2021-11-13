package com.sryoondev.racingcar.step3;

import com.sryoondev.racingcar.step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private MovableChecker movableChecker;
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
            ResultView.draw(car);
        }
    }
}