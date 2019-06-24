package com.mommoo.step2;

import java.util.Random;

public class RacingCarMovingConditioner {
    private static final int MAX_RANDOM_RANGE = 10;
    private static final int MINIMUM_MOVING_CONDITION = 4;

    public static boolean isMoveCondition() {
        Random random = new Random();
        int randomIntValue = random.nextInt(MAX_RANDOM_RANGE);
        return randomIntValue >= MINIMUM_MOVING_CONDITION;
    }
}
