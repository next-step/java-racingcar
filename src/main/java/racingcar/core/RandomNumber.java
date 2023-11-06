package racingcar.core;

import java.util.Random;

public class RandomNumber {
    private final Random random = new Random();
    private static final int RANDOM_MAX_BOUND = 10;

    public int getNumber() {
        return random.nextInt(RANDOM_MAX_BOUND);
    }
}
