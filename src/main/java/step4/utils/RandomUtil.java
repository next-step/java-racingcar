package step4.utils;

import java.util.Random;

public class RandomUtil {

    public final Random random;
    private final static int BOUND_CONDITION = 10;

    public RandomUtil() {
        random = new Random();
    }

    public int generateRandomNumber() {
        return random.nextInt(BOUND_CONDITION);
    }
}
