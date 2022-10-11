package com.nextlevel.kky.racing.core;

import java.util.Random;

public class RandomIntegerGenerator implements IntegerGenerator {

    private static final int UPPER_BOUND = 10;

    private final Random random = new Random();

    @Override
    public int getValue() {
        return random.nextInt(UPPER_BOUND);
    }
}
