package model;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public int generate() {
        final Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
