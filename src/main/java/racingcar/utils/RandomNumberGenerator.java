package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();
    private static final int MAX_BOUND = 10;

    private RandomNumberGenerator() {
    }

    public static int generate() {
        return random.nextInt(MAX_BOUND);
    }
}
