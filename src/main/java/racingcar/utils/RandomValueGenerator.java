package racingcar.utils;

import java.util.Random;

public class RandomValueGenerator {
    private static final int LIMIT_RANDOM_VALUE = 9;

    public static int createRandomValue() {
        return new Random().nextInt(LIMIT_RANDOM_VALUE);
    }
}
