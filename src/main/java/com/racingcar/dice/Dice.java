package com.racingcar.dice;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();
    private static final int BOUND_VALUE = 10;

    public static int getNumber() {
        return random.nextInt(BOUND_VALUE);
    }
}
