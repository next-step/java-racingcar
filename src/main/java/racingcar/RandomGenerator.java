package racingcar;

import java.util.Random;

public class RandomGenerator {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final Random RANDOM = new Random();

    public static int generateNumber() {
        return RANDOM.nextInt(MAX_VALUE + MIN_VALUE) + MIN_VALUE;
    }
}
