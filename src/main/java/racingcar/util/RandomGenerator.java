package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    public static final int RANDOM_NUMBER_RANGE = 10;
    private static final Random random = new Random();

    private RandomGenerator() {}

    public static int getNumber() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
