package com.rick.racing.controller;

import java.util.Random;

public class RandomCarMovingStrategy implements CarMovingStrategy {

    private static final int RANDOM_BOUND = 10;
    private static final int GO_THRESHOLD = 4;

    private final Random random;

    private RandomCarMovingStrategy() {
        random = new Random();
    }

    public static CarMovingStrategy create() {
        return new RandomCarMovingStrategy();
    }

    @Override
    public boolean isGo() {
        return random.nextInt(RANDOM_BOUND) >= GO_THRESHOLD;
    }
}
