package racingcar.util;

import java.util.Random;

public class RandomNumberUtils {
    private static final int BOUND = 10;

    public static int executeRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
