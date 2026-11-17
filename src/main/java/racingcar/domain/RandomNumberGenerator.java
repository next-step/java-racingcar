package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final int bound;
    private final Random random;

    public RandomNumberGenerator(int bound) {
        this.bound = bound;
        random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(bound);
    }
}
