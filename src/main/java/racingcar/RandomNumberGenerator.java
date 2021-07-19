package racingcar;

import java.util.Random;

class RandomNumberGenerator {
    private static final Random random = new Random();

    private static final int BOUND = 10;

    private RandomNumberGenerator() {
    }

    public static int generate() {
        return random.nextInt(BOUND);
    }
}
