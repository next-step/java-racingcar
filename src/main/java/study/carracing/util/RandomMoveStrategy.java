package study.carracing.util;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int MOVE_CONDITION_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(BOUND) >= MOVE_CONDITION_NUMBER;
    }
}
