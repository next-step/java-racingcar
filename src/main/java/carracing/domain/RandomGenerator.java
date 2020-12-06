package carracing.domain;

import java.util.Random;

class RandomGenerator {
    private static final int RANDOM_RULE_NUMBER = 10;

    private final Random random = new Random();

    public int generateZeroToNineInt() {
        return random.nextInt(RANDOM_RULE_NUMBER);
    }
}
