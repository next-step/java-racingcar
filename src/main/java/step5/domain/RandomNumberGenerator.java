package step5.domain;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    private static final int MAX_BOUND = 10;

    public int createRandomNumber() {
        return random.nextInt(MAX_BOUND);
    }
}
