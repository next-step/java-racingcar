package study.step4.domain.strategy;

import study.step4.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy{
    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_MAX_LIMIT = 9;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.impl(RANDOM_MAX_LIMIT) >= MOVE_CONDITION;
    }
}
