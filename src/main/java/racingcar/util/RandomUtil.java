package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANDOM_RANGE = 10;

    public static int generateMovePossibleNumber() {
        return new Random().nextInt(RANDOM_RANGE);
    }
}
