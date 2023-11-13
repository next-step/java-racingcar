package carRacing.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 10;

    @Override
    public int generate() {
        return RANDOM.nextInt(MAX_NUMBER);
    }
}
