package edu.nextstep.camp.carracing.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final int bound;
    private final Random random = new Random();

    public RandomNumberGenerator(int bound) {
        this.bound = bound;
    }

    @Override
    public int generateNumber() {
        return random.nextInt(this.bound);
    }
}
