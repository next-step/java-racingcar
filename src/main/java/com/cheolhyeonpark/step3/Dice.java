package com.cheolhyeonpark.step3;

import java.util.Random;

public class Dice {

    public static final int RANDOM_BOUND = 10;

    private final Random random = new Random();

    public int rollDice() {
        return random.nextInt(RANDOM_BOUND);
    }
}
