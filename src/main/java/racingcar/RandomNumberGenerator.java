package racingcar;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MAXIMUM_VALUE = 10;
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(MAXIMUM_VALUE);
    }
}
