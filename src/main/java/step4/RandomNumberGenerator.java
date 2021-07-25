package step4;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_INT_BOUND = 10;

    private static RandomNumberGenerator randomNumberGenerator = null;

    private final Random random;

    private RandomNumberGenerator() {
        this.random = new Random();
    }

    public static RandomNumberGenerator getRandomNumberGenerator(){
        if (randomNumberGenerator == null) {
            randomNumberGenerator = new RandomNumberGenerator();
        }

        return randomNumberGenerator;
    }

    public int getRandomInt() {
        return random.nextInt(RANDOM_INT_BOUND);
    }
}
