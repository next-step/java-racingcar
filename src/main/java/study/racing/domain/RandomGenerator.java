package study.racing.domain;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {

    private final Random random;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    @Override
    public int random(int bound) {
        return random.nextInt(bound);
    }
}
