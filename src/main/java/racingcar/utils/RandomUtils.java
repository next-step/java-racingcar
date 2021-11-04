package racingcar.utils;

import java.util.Random;

public final class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int getRandomNumber(int bound) {
        return RANDOM.nextInt(bound);
    }
}
