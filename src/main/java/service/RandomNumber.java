package service;

import java.util.Random;

public class RandomNumber {
    private static Random random = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;

    public static int makeRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
