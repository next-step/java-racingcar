package racingcar;

import java.util.Random;

class RandomNumberGenerator {
    private static final int BOUND = 10;
    
    private static final Random random = new Random();

    private RandomNumberGenerator() {
    }

    static int generate() {
        return random.nextInt(BOUND);
    }
}
