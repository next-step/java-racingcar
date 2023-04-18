package car;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVEMENT_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        int randomNumber = new Random().nextInt(RANDOM_BOUND);
        return randomNumber >= MOVEMENT_THRESHOLD;
    }
}
