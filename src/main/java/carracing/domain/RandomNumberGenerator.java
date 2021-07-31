package carracing.domain;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_BOUND = 10;

    private final Random random;

    private RandomNumberGenerator(Random random) {
        this.random = random;
    }

    public static RandomNumberGenerator of(Random random) {
        return new RandomNumberGenerator(random);
    }

    public Number generateRandomNumber() {
        return Number.of(random.nextInt(RANDOM_NUMBER_BOUND));
    }
}
