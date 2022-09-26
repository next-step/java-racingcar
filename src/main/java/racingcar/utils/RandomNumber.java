package racingcar.utils;

import java.util.Random;

public final class RandomNumber {

    private static final Random random = new Random();
    private static final int MAX_NUM = 10;

    private RandomNumber() {
        throw new AssertionError("No utils.RandomNumber instance For you!");
    }

    public static int generate() {
        return random.nextInt(MAX_NUM);
    }
}
