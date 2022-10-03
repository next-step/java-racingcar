package racingcar;

import racingcar.strategy.MovingStrategy;

public class TestMovingStrategy {
    public static class TestSuccessMoveStrategy implements MovingStrategy {

        @Override
        public boolean isMove() {
            return true;
        }
    }

    public static class TestFailMoveStrategy implements MovingStrategy {

        @Override
        public boolean isMove() {
            return false;
        }
    }
}
