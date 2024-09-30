package racing.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = new Random();

    private static final int MAX_NUMBER_BOUND = 10;

    @Override
    public int generate() {
        return random.nextInt(MAX_NUMBER_BOUND);
    }
}
