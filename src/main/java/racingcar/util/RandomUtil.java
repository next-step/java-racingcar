package racingcar.util;

import java.util.Random;

public class RandomUtil {
    public static final int RANDOM_RANGE = 10;

    public static int generateMovePossibleNumber() {
        return new Random().nextInt(RANDOM_RANGE);
    }
}
