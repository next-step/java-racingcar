package step_3.util;

import java.util.Random;

public class RandomUtils {

    public static final int MAX_RANDOM_NUMBER = 10;
    private static final Random rd = new Random();

    private RandomUtils() {
    }

    public static int randomNumber(int maxRandomNumber) {
        return rd.nextInt(maxRandomNumber);
    }
}
