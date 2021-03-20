package step4;

import java.util.Random;

public class RandomNumber {

    private static final Random random = new Random();

    private RandomNumber() {}

    public static int randomNumberGenerator() {
        return random.nextInt(10);
    }
}

