package carRacing.util;

import java.util.Random;

public class RandomIntUtil {
    private static final int RANDOM_INT_BOUNDARY = 10;

    private static Random random = new Random();

    private RandomIntUtil() {
    }

    public static int getRandomInt() {
        return random.nextInt(RANDOM_INT_BOUNDARY);
    }
}
