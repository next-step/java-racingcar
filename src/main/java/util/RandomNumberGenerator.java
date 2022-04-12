package util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();
    private static final int MAX = 9;

    private RandomNumberGenerator() {
    }

    public static int getRandomNumber() {
        return random.nextInt(MAX + 1);
    }
}
