package study.step4.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_MAX_LIMIT = 9;

    private RandomNumberGenerator() {
    }

    public static int impl(int maxValue) {
        Random random = new Random();
        int num = random.nextInt(maxValue);
        if (num > RANDOM_MAX_LIMIT) {
            throw new IllegalArgumentException("Please change the maxValue");
        }

        return num;
    }
}
