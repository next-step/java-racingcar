package racingcar.util;

import java.util.Random;

public class RandomGenerator {

    private static final int MAX_RANGE_VALUE = 10;

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANGE_VALUE);
    }
}
