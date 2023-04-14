package racingcar.domain;

import java.util.Random;

public class RandomGenerator {

    private static final int RANDOM_BOUND_NUM = 10;

    private static final Random random = new Random();

    public static int getValue() {
        return random.nextInt(RANDOM_BOUND_NUM);
    }
}
