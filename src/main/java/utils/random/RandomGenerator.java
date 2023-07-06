package utils.random;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    public static int extractRandomSingleDigit() {
        return random.nextInt(10);
    }
}
