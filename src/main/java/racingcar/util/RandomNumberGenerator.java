package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();
    private static final int RANDOM_UPPER_BOUND = 10;

    @Override
    public int generate() {
        return random.nextInt(RANDOM_UPPER_BOUND);
    }

}
