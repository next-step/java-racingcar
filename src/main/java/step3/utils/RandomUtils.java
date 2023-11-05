package step3.utils;

import java.util.Random;

public class RandomUtils {

    private static final int RANDOM_BOUND_NUMBER = 10;

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND_NUMBER);
    }
}
