package study;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_RANGE = 10;

    public static int generateRandomNumber() {
        return RANDOM.nextInt(RANDOM_RANGE);
    }
}
