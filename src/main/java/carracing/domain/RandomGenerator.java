package carracing.domain;

import java.util.Random;

class RandomGenerator {
    private static final int RANDOM_BOUND_NUMBER = 10;

    private final Random random = new Random();

    public int generateZeroToNineInt() {
        return random.nextInt(RANDOM_BOUND_NUMBER);
    }
}
