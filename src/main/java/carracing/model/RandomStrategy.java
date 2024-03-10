package carracing.model;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    private static final int RANDOM_INTEGER_BOUND_ZERO_TO_NINE = 10;
    private static final int RANDOM_MOVABLE_CRITERIA = 4;
    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_INTEGER_BOUND_ZERO_TO_NINE) >= RANDOM_MOVABLE_CRITERIA;
    }
}
