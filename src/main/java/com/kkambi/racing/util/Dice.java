package com.kkambi.racing.util;

import java.util.Random;

public class Dice {

    private static final Random random = new Random();

    public static int roll(int bound) {
        return random.nextInt(bound);
    }
}
