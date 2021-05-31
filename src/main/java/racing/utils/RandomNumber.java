package racing.utils;

import java.util.Random;

public final class RandomNumber {
    private static final Random random = new Random();

    private RandomNumber() {
    }

    public static int makeRandomNumber() {
        return random.nextInt(10);
    }
}
