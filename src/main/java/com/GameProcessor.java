package com;

import com.view.ResultView;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameProcessor {
    private static final int RANDOM_VALUE_BOUND = 10;
    private static final int MOVE_POSSIBLE_BOUND = 4;

    public int getRandomValue() {
        return new Random().nextInt(RANDOM_VALUE_BOUND);
    }

    public boolean isMovePossible(int i) {
        return i >= MOVE_POSSIBLE_BOUND ? true : false;
    }

    public List<Car> start(NumberSet myNumber) {
        List<Car> cars = new LinkedList<>();

        for (int idx = 0; idx < myNumber.getCarCount(); idx++) {
            cars.add(new Car(0));
        }

        System.out.println("실행 결과");

        for (int idx = 0; idx < myNumber.getAttemptCount(); idx++) {
            for (Car car : cars) {
                car.move(isMovePossible(getRandomValue()));
            }

            new ResultView().showResult(cars);
        }

        return cars;
    }
}
