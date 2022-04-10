package racingcar.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;

    @Override
    public int generate() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }
}
