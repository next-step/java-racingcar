package racingcar.common.util;

import java.util.Random;

public class RandomUtils {
    private static final int DEFAULT_RANDOM_SIZE = 10;
    private static final Random RANDOM = new Random();

    private RandomUtils() {}

    public static int getNextInt() {
        return RANDOM.nextInt(DEFAULT_RANDOM_SIZE);
    }
}
