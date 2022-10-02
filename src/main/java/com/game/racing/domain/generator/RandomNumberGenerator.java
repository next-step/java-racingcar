package com.game.racing.domain.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Integer RANDOM_INTEGER_MAX_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public Integer generate() {
        return random.nextInt(RANDOM_INTEGER_MAX_BOUND);
    }
}
