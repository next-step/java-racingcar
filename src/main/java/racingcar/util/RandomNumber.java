package racingcar.util;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int RANDOM_BOUND = 10;

    public static int makeRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
