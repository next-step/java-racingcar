package racingcar.pattern;

import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = new SecureRandom();

    @Override
    public int generate() {
        return random.nextInt(MAX +1);
    }
}
