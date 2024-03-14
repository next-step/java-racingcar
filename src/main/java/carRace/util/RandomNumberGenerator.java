package carRace.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random randomNumberGenerator = new Random();

    private static final int RANDOM_NUMBER_BOUND = 10;

    private RandomNumberGenerator() {
    }

    public static int createRandomNumber() {
        return randomNumberGenerator.nextInt(RANDOM_NUMBER_BOUND);
    }
}
