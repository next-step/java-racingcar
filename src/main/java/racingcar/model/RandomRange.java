package racingcar.model;

import java.util.Random;

public class RandomRange {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;

    private RandomRange() {
        throw new AssertionError();
    }

    public static int getRandomValue() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }
}
