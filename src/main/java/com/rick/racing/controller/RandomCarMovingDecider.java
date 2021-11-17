package com.rick.racing.controller;

import com.rick.racing.model.Car;
import java.util.Random;

public class RandomCarMovingDecider implements CarMovingDecider {

    private static final int RANDOM_BOUND = 10;
    private static final int GO_THRESHOLD = 4;

    private final Random random;

    private RandomCarMovingDecider() {
        random = new Random();
    }

    public static CarMovingDecider create() {
        return new RandomCarMovingDecider();
    }

    public boolean isGo() {
        return random.nextInt(RANDOM_BOUND) >= GO_THRESHOLD;
    }

    @Override
    public void move(Car car) {
        if (isGo()) {
            car.moveForward();
        }
    }
}
