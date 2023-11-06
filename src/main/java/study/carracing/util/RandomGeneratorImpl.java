package study.carracing.util;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public int nextInt(int bound) {
        return RANDOM.nextInt();
    }
}
