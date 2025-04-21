package step5.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private static final Random random = new Random();
    private static final int BOUND = 10;
    @Override
    public int generate() {
        return random.nextInt(BOUND);
    }
}
