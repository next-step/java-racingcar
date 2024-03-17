package util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_INT_MAX_LIMIT = 10;
    public static Integer getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_INT_MAX_LIMIT);
    }
}
