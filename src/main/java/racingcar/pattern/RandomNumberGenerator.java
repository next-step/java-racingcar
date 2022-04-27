package racingcar.pattern;

import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final int MAX = 9;
    private static final Random RANDOM = new SecureRandom();

    @Override
    public int generate() {
        return RANDOM.nextInt(MAX + 1);
    }
}
