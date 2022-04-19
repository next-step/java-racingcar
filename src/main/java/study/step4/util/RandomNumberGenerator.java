package study.step4.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_MAX_LIMIT = 9;

    private RandomNumberGenerator() {
    }

    public static int impl() {
        Random random = new Random();
        int num = random.nextInt(RANDOM_MAX_LIMIT);

        return num;
    }
}
