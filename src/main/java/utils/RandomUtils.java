package utils;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
    }

    private static final Random RANDOM = new Random();

    public static int nextInt(final int bound) {
        return RANDOM.nextInt(bound);
    }
}
