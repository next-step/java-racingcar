package racingcar;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;

    public static int makeRandomValue() {
        return RANDOM.nextInt(RANDOM_BOUND);
    }
}
