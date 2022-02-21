package racingcar.util;

import java.util.Random;

public class RandomGenerator {

    private static final int MAX_RANGE_VALUE = 10;
    private static final Random random = new Random();

    public static int generateRandomNumber() {
        return random.nextInt(MAX_RANGE_VALUE);
    }
}
