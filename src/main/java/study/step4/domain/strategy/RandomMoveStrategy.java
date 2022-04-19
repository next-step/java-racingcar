package study.step4.domain.strategy;

import study.step4.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy{
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.impl() >= MOVE_CONDITION;
    }
}
