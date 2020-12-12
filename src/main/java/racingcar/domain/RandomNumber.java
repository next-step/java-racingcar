package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_RANGE_NO = 10;

    private final Random RANDOM = new Random();

    public int condition() {
        return RANDOM.nextInt(RANDOM_RANGE_NO);
    }
}
