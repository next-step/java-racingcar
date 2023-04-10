package racingcar;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_NUMBER_BOUND = 10;
    static Random random = new Random();

    private RandomNumber() {
    }

    public static int getNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
