package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    private RandomGenerator() {
    }

    public int generator() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static RandomGenerator getInstance() {
        return new RandomGenerator();
    }
}
