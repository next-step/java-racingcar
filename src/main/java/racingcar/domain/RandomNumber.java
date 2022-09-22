package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();

    private static final int UPPER_BOUND = 10;

    public static boolean isNotLessThanThreshold(int threshold) {
        return random.nextInt(UPPER_BOUND) >= threshold;
    }
}
