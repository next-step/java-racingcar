package racingcar.util;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {

    static final int LIMIT_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public int getNumber() {
        return random.nextInt(LIMIT_BOUND);
    }
}
