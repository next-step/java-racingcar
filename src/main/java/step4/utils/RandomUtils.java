package step4.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int getRandomNum(int maxBound) {
        return random.nextInt(maxBound);
    }
}
