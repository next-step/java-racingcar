package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();
    private static final int BOUND_TEN = 10;

    private RandomUtil() {
    }

    public static int getRandomIntBetweenZeroToNine() {
        return random.nextInt(BOUND_TEN);
    }
}
