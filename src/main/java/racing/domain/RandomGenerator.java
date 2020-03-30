package racing.domain;

import java.util.Random;

public class RandomGenerator {
    private static final int MAX_RANDOM_VALUE = 10;

    private final Random random;

    public RandomGenerator(long seed) {
        random = new Random(seed);
    }

    public int nextInt() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}