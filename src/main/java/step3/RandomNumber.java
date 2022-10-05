package step3;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int NUMBER_BOUND = 10;

    public static int generateRandomNumber() {
        return random.nextInt(NUMBER_BOUND);
    }
}
