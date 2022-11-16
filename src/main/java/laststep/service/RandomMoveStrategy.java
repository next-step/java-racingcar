package laststep.service;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MAX_BOUND = 9;
    public static final int MOVE_CONDITION = 4;
    private final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(MAX_BOUND) >= MOVE_CONDITION;
    }
}
