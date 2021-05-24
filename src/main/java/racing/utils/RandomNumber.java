package racing.utils;

import java.util.Random;

public final class RandomNumber {
    private RandomNumber() {
    }

    public static int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
