package racingcar.random;

import java.util.Random;

public class GenerateRandom {
    private static final int RANDOM_BOUND = 10;
    private static final int MINIMUM_VALUE = 3;

    public static int randomForward() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND) > MINIMUM_VALUE ? 1 : 0;
    }
}

