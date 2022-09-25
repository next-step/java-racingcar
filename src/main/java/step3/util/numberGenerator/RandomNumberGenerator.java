package step3.util.numberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MAX_BOUND = 10;
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(MAX_BOUND);
    }
}
