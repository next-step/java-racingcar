package carracing.model.car.strategy;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    private static final int RANDOM_INTEGER_BOUND_ZERO_TO_NINE = 10;
    private static final int RANDOM_MOVABLE_CRITERIA = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(RANDOM_INTEGER_BOUND_ZERO_TO_NINE) >= RANDOM_MOVABLE_CRITERIA;
    }
}
