package racingcar.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_MAX = 10;

    private RandomUtils() {

    }

    public static int generateRandomInt() {
        return RANDOM.nextInt(RANDOM_MAX);
    }
}
