package util;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int nextInt(int maxValue) {
        return random.nextInt(maxValue);
    }
}
