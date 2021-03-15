package step3.study.util;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {
    private static final int RANDOM_BOUND = 10;
    private Random random;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    @Override
    public int createNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
