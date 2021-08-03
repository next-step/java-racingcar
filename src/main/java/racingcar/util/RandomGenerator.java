package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    private static final int MAX_GENERATE = 10;

    public int generator() {
        Random random = new Random();
        return random.nextInt(MAX_GENERATE);
    }

    public static RandomGenerator getInstance() {
        return new RandomGenerator();
    }
}
