package racingcar;

import java.util.Random;

public class RandomValueGenerator {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;

    private RandomValueGenerator() {

    }

    public static int generate() {
        return RANDOM.nextInt(RANDOM_BOUND);
    }
}
