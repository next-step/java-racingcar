package racingcar.common;

import java.util.Random;

public class RandomGenerator {
    private static final int RANGE;
    private static final Random GENERATOR;

    static {
        RANGE = 10;
        GENERATOR = new Random();
    }

    public static int generateRandomInt() {
        return GENERATOR.nextInt(RANGE);
    }
}
