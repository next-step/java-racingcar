package game.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = new Random();
    private final int bound;

    public RandomNumberGenerator(int bound) {
        this.bound = bound;
    }

    @Override
    public int getNumber() {
        return random.nextInt(bound);
    }
}
