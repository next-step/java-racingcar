package util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int getRandomValue(int maxValue) {
        return random.nextInt(maxValue);
    }
}
