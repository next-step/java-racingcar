package racingcar.pattern;

import java.security.SecureRandom;
import java.util.Random;

public class RandomValueGenerator implements ValueGenerateStrategy {

    private RandomValueGenerator() {
    }

    private static final Random random = new SecureRandom();
    private static final RandomValueGenerator INSTANCE = new RandomValueGenerator();

    public static RandomValueGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
