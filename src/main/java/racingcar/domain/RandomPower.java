package racingcar.domain;

import java.util.Random;

public class RandomPower {

    private static final Random random = new Random();
    private static final int RANDOM_RANGE = 10;

    public static int nextInt() {
        return random.nextInt(RANDOM_RANGE);
    }
}
