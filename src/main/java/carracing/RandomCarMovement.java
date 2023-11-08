package carracing;

import java.util.Random;

public class RandomCarMovement implements MoveStrategy {

    final int RANDOM_RANGE_0_TO_9 = 10;
    final int MOVABLE_LOWER_BOUND = 4;
    @Override
    public boolean executeMove() {
        return generateRandomValue() >= MOVABLE_LOWER_BOUND;
    }

    private int generateRandomValue() {
        return new Random().nextInt(RANDOM_RANGE_0_TO_9);
    }
}
