package racingcar.domain;

import java.util.Random;

public class NumberGenerator {

    private static final int BOUND = 10;
    private static final Random random = new Random();

    private NumberGenerator() {
    }

    public static int generate() {
        return random.nextInt(BOUND);
    }
}
