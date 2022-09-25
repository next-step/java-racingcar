package com.game.racing.generator;

import java.util.Random;

public class RandomIntegerGenerator implements IntegerGenerator {

    private static final Integer RANDOM_INTEGER_MAX_BOUND = 10;
    private final Random random;

    public RandomIntegerGenerator() {
        random = new Random();
    }

    @Override
    public Integer generate() {
        return random.nextInt(RANDOM_INTEGER_MAX_BOUND);
    }
}
