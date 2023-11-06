package study.carracing.domain;

import java.util.Random;
import study.carracing.util.RandomGenerator;

public class RandomGeneratorImpl implements RandomGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public int nextInt(int bound) {
        return RANDOM.nextInt();
    }
}
