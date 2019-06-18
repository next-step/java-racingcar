package com.mommoo.step2;

import java.util.Random;

public class RacingCarMovingConditioner {
    private final Random random = new Random();

    public boolean isMoveCondition() {
        int randomIntValue = random.nextInt(10);
        return randomIntValue >= 4;
    }
}
