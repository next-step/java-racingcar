package com.nextlevel.kky.racing.core;

import java.util.Random;

public class RandomIntegerGenerator implements IntegerGenerator {

    private final Random random = new Random();

    @Override
    public int getValue() {
        return random.nextInt(CarMoveCondition.MAX_VALUE + 1);
    }
}
