package game;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random RANDOM = new Random();
    private final int BOUND = 10;

    @Override
    public int generate() {
        return RANDOM.nextInt(BOUND);
    }
}
