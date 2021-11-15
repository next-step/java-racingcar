package racing.utils;

import java.util.Random;

public class RandomGenerator {

    private final Random random = new Random();
    private final int bound;

    public RandomGenerator(int bound) {
        this.bound = bound;
    }

    public int nextInt() {
        return random.nextInt(bound);
    }
}
