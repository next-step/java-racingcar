package racingcar.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    @Override
    public int generator() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
