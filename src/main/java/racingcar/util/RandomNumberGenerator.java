package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();

    private RandomNumberGenerator() {
    }

    public static int generateLessThan(int bound) {
        return RANDOM.nextInt(bound);
    }
}
