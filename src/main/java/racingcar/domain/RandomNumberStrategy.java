package racingcar.domain;

import java.util.Random;

public class RandomNumberStrategy implements NumberStrategy {
    private static final Random random = new Random();

    private static final int UPPER_BOUND = 10;

    public boolean isSameOrOverThreshold(int threshold) {
        return random.nextInt(UPPER_BOUND) >= threshold;
    }
}
