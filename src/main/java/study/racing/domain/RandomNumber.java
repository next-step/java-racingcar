package study.racing.domain;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_RANGE = 10;

    private final Random random;

    public RandomNumber() {
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(RANDOM_RANGE);
    }

}
