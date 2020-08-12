package racingcar.utils;

import java.util.Random;

public class RandomValueGenerator {
    private static final int RANDOM_BOUND = 10;

    public static int randomForward() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }
}

