package racingcar;

import java.util.Random;

public class RandomGenerator implements NumberGenerator{
    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;

    @Override
    public int makeValue() {
        return RANDOM.nextInt(RANDOM_BOUND);
    }
}
