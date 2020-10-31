package step3.utils;

import java.util.Random;

public class RandomUtil {

    private static Random random;
    private final static int BOUND_CONDITION = 10;

    public RandomUtil() {
        random = new Random();
    }

    public static int generateRandomNumber() {
        return random.nextInt(BOUND_CONDITION);
    }
}
