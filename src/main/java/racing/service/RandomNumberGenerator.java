package racing.service;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_MAX_VALUE = 10;

    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(RANDOM_MAX_VALUE);
    }
}
