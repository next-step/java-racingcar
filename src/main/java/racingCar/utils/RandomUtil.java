package racingCar.utils;

import java.util.Random;

public class RandomUtil {
    private static final int MAX = 9;
    private static final Random random = new Random();

    private RandomUtil() {
    }

    public static int getNumber() {
        return random.nextInt(MAX+1);
    }
}
