package step3.study.util;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_BOUND = 10;
    private Random random;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    public int getRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
