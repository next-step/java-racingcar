package step3.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANDOM_BASE_VALUE = 10;
    private static final Random random = new Random();

    private RandomUtil() { }

    public static int getRandomIntBetweenZeroToNine() {
        return random.nextInt(RANDOM_BASE_VALUE);
    }
}
