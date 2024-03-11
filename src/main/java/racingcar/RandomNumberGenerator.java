package racingcar;

import java.util.Random;

public final class RandomNumberGenerator {

    private static final Random random = new Random();
    private static final int TEN = 10;

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumberBetweenZeroAndNine() {
        return random.nextInt(TEN);
    }
}
