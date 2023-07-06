package utils.random;

import java.util.Random;

public class RandomGenerator {

    public static int extractRandomSingleDigit() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
