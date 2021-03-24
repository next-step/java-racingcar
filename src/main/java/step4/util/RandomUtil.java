package step4.util;

import java.util.Random;

public class RandomUtil {
    private RandomUtil() {
    }

    private static final int RANGE = 10;

    private static final Random random = new Random();

    public static int getRandomValue() {
        return random.nextInt(RANGE);
    }
}
