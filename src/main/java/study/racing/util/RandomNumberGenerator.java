package study.racing.util;

import java.util.Random;

public class RandomNumberGenerator implements RandomGenerator<Integer> {
    private static final Random random = new Random();

    private RandomNumberGenerator() { }

    public static RandomNumberGenerator getInstance() {
        return LazyHolder.instance;
    }

    @Override
    public Integer generate() {
        return random.nextInt(10);
    }

    private static class LazyHolder {
        private static final RandomNumberGenerator instance = new RandomNumberGenerator();
    }
}
