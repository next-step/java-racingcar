package carracingwinner.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    private static final int RANDOM_BOUND = 10;

    private RandomUtils() {

    }

    public static int randomInt() {
        return RANDOM.nextInt(RANDOM_BOUND);
    }

}
