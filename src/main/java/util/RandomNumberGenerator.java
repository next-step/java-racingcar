package util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_INT_MAX_LIMIT = 10;
    private static final Random random = new Random();
    public static Integer getRandomNumber() {
        return random.nextInt(RANDOM_INT_MAX_LIMIT);
    }
}
