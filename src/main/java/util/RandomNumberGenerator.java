package util;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random = new Random();
    private static final int MAX_BOUND = 10;

    public static int getRandomNumber() {
        return random.nextInt(MAX_BOUND);
    }
}
