package step4.utils;

import java.util.Random;

public class RandomUtil {

    private final static int BOUND_CONDITION = 10;
    private final static Random random = new Random();

    private RandomUtil() {
    }


    public static int generateRandomNumber() {
        return random.nextInt(BOUND_CONDITION);
    }
}
