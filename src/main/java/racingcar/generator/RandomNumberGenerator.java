package racingcar.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAXIMUM_VALUE = 10;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(MAXIMUM_VALUE);
    }
}
