package step3.common;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
