package step4.generator;

import java.util.Random;


public class RandomNumberGenerator {

    private static final Random random = new Random();
    private static final int LIMIT = 10;

    private static RandomNumberGenerator instance;

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        if (isInstanceNull()) {
            instance = new RandomNumberGenerator();
        }
        return instance;
    }

    private static boolean isInstanceNull() {
        return instance == null;
    }

    public int generateRandomNumber() {
        return random.nextInt(LIMIT);
    }

}
