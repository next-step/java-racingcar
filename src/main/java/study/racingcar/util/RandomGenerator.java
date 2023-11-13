package study.racingcar.util;

import java.util.Random;

public class RandomGenerator {
    private final Random random;

    private static final int UPPER_BOUND = 10;
    private static final int LOWER_BOUND = 1;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    public int number() {
        return random.nextInt(UPPER_BOUND-LOWER_BOUND) + LOWER_BOUND;
    }
}
