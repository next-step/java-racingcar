package racingcar.random;

import java.util.Random;

public class SimpleRandomNumberGenerator implements RandomNumberGenerator {
    private final Random random;

    private static final int MAX_VALUE = 10;

    public SimpleRandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(MAX_VALUE);
    }
}
