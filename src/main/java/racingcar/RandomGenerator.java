package racingcar;

import java.util.Random;

public class RandomGenerator {
    private Random random;

    private RandomGenerator() {
        random = new Random();
    }

    private static class SingletonHelper {
        private static final RandomGenerator instance = new RandomGenerator();
    }

    public static RandomGenerator getInstance() {
        return SingletonHelper.instance;
    }

    public int getRandomNum() {
        return random.nextInt(10);
    }
}
