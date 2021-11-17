package racingcar.common.util;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {}
    private static int DEFAULT_RANDOM_SIZE = 10;

    public static int getNextInt() {
        return new Random().nextInt(DEFAULT_RANDOM_SIZE);
    }
}
