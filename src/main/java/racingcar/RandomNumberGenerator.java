package racingcar;

import java.util.Random;

public final class RandomNumberGenerator {
    private static final Random RANDOM = new Random();

    private RandomNumberGenerator() {

    }

    public static int randomNumber() {
        return RANDOM.nextInt(10);
    }
}
