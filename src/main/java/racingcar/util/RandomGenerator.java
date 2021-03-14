package racingcar.domain;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    private RandomGenerator() {

    }

    public static int getRandomValue() {
        return RANDOM.nextInt(BOUND);
    }
}
