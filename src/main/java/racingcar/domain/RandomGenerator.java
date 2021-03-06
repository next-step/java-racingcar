package racingcar.domain;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();
    private static final int BOUND = 10;

    public static int getRandomValue() {
        return random.nextInt(BOUND);
    }
}
