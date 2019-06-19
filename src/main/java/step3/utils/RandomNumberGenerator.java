package step3.utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int LIMIT_OF_RANDOM_NUMBER = 10;

    @Override
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(LIMIT_OF_RANDOM_NUMBER);
    }
}
