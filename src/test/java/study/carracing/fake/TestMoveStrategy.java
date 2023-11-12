package study.carracing.fake;

import study.carracing.util.MoveStrategy;

public class TestMoveStrategy implements MoveStrategy {
    private boolean canMove;

    public TestMoveStrategy(boolean canMove) {
        this.canMove = canMove;
    }

    @Override
    public boolean isMovable() {
        return canMove;
    }
}
