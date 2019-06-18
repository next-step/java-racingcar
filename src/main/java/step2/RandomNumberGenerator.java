package step2;

import java.util.Random;

public class RandomNumberGenerator {
    final static int LIMIT_OF_RANDOM_NUMBER = 10;

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(LIMIT_OF_RANDOM_NUMBER);
    }
}
