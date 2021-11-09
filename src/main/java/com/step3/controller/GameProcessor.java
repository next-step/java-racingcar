package com.step3.controller;

import com.step3.model.car.Car;
import com.step3.model.car.CarPosition;
import com.step3.model.InputNumber;
import com.step3.model.car.Cars;
import com.step3.util.RandomUtil;
import com.step3.view.ResultView;

import java.util.LinkedList;
import java.util.List;

public class GameProcessor {
    private static final int MOVE_POSSIBLE_BOUND = 4;

    public void moveCars(InputNumber myNumber) {
        Cars cars = new Cars(myNumber.getCarCount());

        for (int attempt = 0; attempt < myNumber.getAttemptCount(); attempt++) {
            ResultView.showResults(moveCars(cars), attempt);
        }
    }

    private Cars moveCars(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(isMovePossible(RandomUtil.getRandomValue()));
        }

        return cars;
    }

    private boolean isMovePossible(int randomValue) {
        return randomValue >= MOVE_POSSIBLE_BOUND;
    }
}
