package racingcar.common;

import java.util.Random;

public class RandomGenerator {
    private static final Random GENERATOR;

    static {
        GENERATOR = new Random();
    }

    public static int generateRandomInt(int range) {
        return GENERATOR.nextInt(range);
    }
}
