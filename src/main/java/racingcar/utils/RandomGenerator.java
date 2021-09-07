package racingcar.utils;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_VALUE = 10;
    private static final Random RANDOM = new Random();

    public static int randomNumber() {
        return RANDOM.nextInt(RANDOM_VALUE);
    }
}