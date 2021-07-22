package racingCar.utils;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    private RandomUtil() {
    }

    public static int getNumber() {
        return random.nextInt(10);
    }
}
