package step1.racing.common;

import java.util.Random;

public class RandomIntegerGenerator implements RandomNumberGenerator<Integer> {
    private final Random random;

    private RandomIntegerGenerator() {
        this.random = new Random();
    }

    public static RandomIntegerGenerator getInstance() {
        return InstanceHolder.instance;
    }

    @Override
    public Integer gacha(int bound) {
        return random.nextInt();
    }

    private static class InstanceHolder {
        private static final RandomIntegerGenerator instance = new RandomIntegerGenerator();
    }
}
