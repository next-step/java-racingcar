package racingcar.utils;

import java.util.Random;

public class RandomNumberUtil {

    private static final int ROUND_10 = 10;
    private static Random random;

    private RandomNumberUtil() {}

    public static int generateRandomNum() {
        if (random == null) {
            random = new Random();
        }

        return random.nextInt(ROUND_10);
    }

}
