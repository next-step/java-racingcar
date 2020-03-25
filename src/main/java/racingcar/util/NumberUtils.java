package racingcar.util;

import java.util.Random;

public class NumberUtils {
    public static final int ZERO = 0;
    public static final int MOVABLE_NUMBER = 3;
    public static final int RANDOM_BOUND = 10;
    public static final int REDUCE_STEP = 1;
    private static Random random = new Random();

    public static int getRandom() {
        return random.nextInt(RANDOM_BOUND);
    }
}
