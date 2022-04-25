package study.step4.util;

import study.step4.domain.strategy.MoveStrategy;
import study.step4.util.RandomNumberGenerator;

public class TestMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;
    private int input;

    public TestMoveStrategy(int input) {
        this.input = input;
    }

    @Override
    public boolean isMovable() {
        return input >= MOVE_CONDITION;
    }
}
