package utils;

import java.util.Random;

public class RandomNumberUtils {

    private static final Random RANDOM = new Random();

    private RandomNumberUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int getRandomNumber(int bound) {
        return RANDOM.nextInt(bound);
    }
}
