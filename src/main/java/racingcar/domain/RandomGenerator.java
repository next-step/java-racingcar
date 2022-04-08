package racingcar.domain;

import java.util.Random;

public class RandomGenerator {

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int RANDOM_UPPER_BOUND = 10;

    private RandomGenerator() {
        throw new AssertionError();
    }

    public static int generateRandom() {
        return RANDOM_GENERATOR.nextInt(RANDOM_UPPER_BOUND);
    }

}
