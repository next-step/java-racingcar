package utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private final static int RANDOM_NUMBER_UPPER_BOUND = 10;
    private final static Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
