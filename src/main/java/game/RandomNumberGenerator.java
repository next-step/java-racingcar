package game;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random;
    private final int bound;

    public RandomNumberGenerator(int bound) {
        random = new Random();
        this.bound = bound;
    }

    @Override
    public int generate() {
        return random.nextInt(bound);
    }
}
