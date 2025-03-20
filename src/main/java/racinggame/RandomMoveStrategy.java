package racinggame;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVEMENT_THRESHOLD = 4;
    private final Random random = new Random();

    @Override
    public boolean canMove() {
        return random.nextInt(10) >= MOVEMENT_THRESHOLD;
    }
}
