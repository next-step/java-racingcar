package step5.domain;

import java.util.Random;

public class RandomValueGenerator {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_VALUE_UPPER_BOUND = 10;

    public static int generate() {
        return RANDOM.nextInt(RANDOM_VALUE_UPPER_BOUND);
    }
}
