package racing.domain.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MOVABLE_THRESHOLD_NUMBER = 4;
    private static final int BOUND_NUMBER = 10;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {

        return randomize() >= MOVABLE_THRESHOLD_NUMBER;
    }

    private int randomize() {

        return RANDOM.nextInt(BOUND_NUMBER);
    }
}
