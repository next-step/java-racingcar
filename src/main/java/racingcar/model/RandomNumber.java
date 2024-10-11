package racingcar.model;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_NUMBER_BOUND = 10;

    public static int make() {
        Random random = new Random();

        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
