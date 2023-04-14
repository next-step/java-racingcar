package step3;

import java.util.Random;

public class RandomGenerator {
    private final int RANDOM_BOUND_NUM = 10;

    private final Random random;
    public RandomGenerator() {
        random = new Random();
    }

    public int getValue() {
        return random.nextInt(RANDOM_BOUND_NUM);
    }
}
