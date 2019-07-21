package com.mommoo.step2.domain;

import java.util.Random;

public class CarMovingConditioner {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_RANGE = 10;
    private static final int MINIMUM_MOVING_CONDITION = 4;
    private final boolean isCanMove;

    public CarMovingConditioner() {
        this.isCanMove = isCanMove();
    }

    public boolean isCanMove() {
        return this.isCanMove;
    }

    private static boolean computeIsCanMove() {
        int randomIntValue = RANDOM.nextInt(MAX_RANDOM_RANGE);
        return randomIntValue >= MINIMUM_MOVING_CONDITION;
    }
}
