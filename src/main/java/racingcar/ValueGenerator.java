package racingcar;

import java.security.SecureRandom;
import java.util.Random;

public class ValueGenerator {

    private static final Random random = new SecureRandom();

    private ValueGenerator() {
    }

    public static Integer generateRandomValue() {
        return random.nextInt(10);
    }
}
