package study.racing.domain;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator{

    private final Random random;

    public RandomGeneratorImpl(Random random) {
        this.random = random;
    }

    @Override
    public int random(int bound) {
        return random.nextInt(bound);
    }
}
