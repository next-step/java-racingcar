package domain;

import util.MoveStrategy;

public class TestMoveStrategy implements MoveStrategy {
    private static final TestMoveStrategy testMoveStrategy = new TestMoveStrategy();
    private static boolean moveState = false;

    private TestMoveStrategy() {
    }

    public static TestMoveStrategy getInstance(boolean moveState) {
        TestMoveStrategy.moveState = moveState;
        return testMoveStrategy;
    }

    @Override
    public boolean isMovable() {
        return moveState;
    }
}
