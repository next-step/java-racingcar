package carracing.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private final int RANDOM_RANGE = 10;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }
}
