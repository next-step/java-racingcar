package racingcar;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_BOUND = 10;
    private static final Random random = new Random();

    public static int generate() {
        return random.nextInt(RANDOM_BOUND);
    }
}
