package racingcar.util;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int RANDOM_MAX_BOUND = 10;

    public static int getNumber() {
        return random.nextInt(RANDOM_MAX_BOUND);
    }
}
