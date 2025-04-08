package model;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVING_THRESHOLD = 4;
    private static final int UPPER_BOUND = 10;
    private final Random rand = new Random();

    @Override
    public boolean isMovable() {
        return rand.nextInt(UPPER_BOUND) >= MOVING_THRESHOLD;
    }
}
