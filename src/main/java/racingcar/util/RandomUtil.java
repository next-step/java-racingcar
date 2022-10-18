package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();
    public static final int RANDOM_RANGE = 10;

    public static int generateMovePossibleNumber() {
        return random.nextInt(RANDOM_RANGE);
    }
}
