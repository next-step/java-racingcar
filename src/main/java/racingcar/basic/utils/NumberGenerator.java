package racingcar.basic.utils;

import java.util.Random;

public class NumberGenerator {

    private static final int MAX_BOUND = 8;
    private static final Random random = new Random();

    private NumberGenerator() {
    }

    public static int randomNumber() {
        return random.nextInt(MAX_BOUND) + 1;
    }
}
