package racingcar.utils;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
        throw new AssertionError();
    }

    public static int random(int randomBound) {
        Random random = new Random();
        return random.nextInt(randomBound);
    }
}
