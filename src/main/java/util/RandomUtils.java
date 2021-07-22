package util;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static int nextInt(int minValue, int maxValue) {
        return random.nextInt(maxValue - minValue) + minValue;
    }

    public static int nextInt(int maxValue) {
        return random.nextInt(maxValue);
    }
}
