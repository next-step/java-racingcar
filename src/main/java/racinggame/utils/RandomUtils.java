package racinggame.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    private RandomUtils() {
        throw new IllegalStateException("utility class");
    }

    public static int getRandomNumber(final int bits) {
        return RANDOM.nextInt(bits);
    }

}
