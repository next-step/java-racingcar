package racing.generator;

import java.util.Random;

public class RandomGenerator implements NumberGenerator{
    private static final Random RANDOM = new Random();
    private static final int RANDOM_MAX_VALUE = 10;

    @Override
    public int generate() {
        return RANDOM.nextInt(RANDOM_MAX_VALUE);
    }
}
