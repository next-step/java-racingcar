package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int BOUND = 10;
    private final Random random;

    public RandomNumberGenerator() {
        random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(BOUND);
    }
}
