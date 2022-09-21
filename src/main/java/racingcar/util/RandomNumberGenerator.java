package racingcar.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
    private static final Random RANDOM = ThreadLocalRandom.current();

    private RandomNumberGenerator() {
    }

    public static int generateLessThan(int bound) {
        return RANDOM.nextInt(bound);
    }
}
