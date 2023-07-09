package utils.random;

import java.util.Random;

public class RandomGenerator {

    private final Random random = new Random();

    public int extractRandomSingleDigit() {
        return random.nextInt(10);
    }
}
