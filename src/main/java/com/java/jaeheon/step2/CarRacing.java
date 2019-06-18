package com.java.jaeheon.step2;

import java.util.List;
import java.util.Random;

public class CarRacing {
    private static final int CONDITION_LIMIT = 10;

    private final CarManagement carManagement;
    private final int numberOfAttempts;
    private final Random random;

    public CarRacing(CarManagement carManagement, int numberOfAttempts) {
        this.carManagement = carManagement;
        this.numberOfAttempts = numberOfAttempts;
        this.random = new Random();
    }

    public void carRacingStart() {
        for (int i = 0; i < numberOfAttempts; i++) {
            race();
        }
    }

    private List<Car> race() {
        for (Car car : carManagement.Cars()) {
            car.attempt(createCondition());
        }
        return carManagement.Cars();
    }

    private int createCondition() {
        return random.nextInt(CONDITION_LIMIT);
    }
}
