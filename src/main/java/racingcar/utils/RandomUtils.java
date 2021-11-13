package racingcar.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomUtils {

    private static final int DEFAULT_BOUND = 10;

    private static Random RANDOM = new SecureRandom();

    private RandomUtils() {

    }

    public static int nextInt() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

}
