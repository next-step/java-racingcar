package racingCar;

import racingCar.domain.MoveStrategy;

public class TestMoveStrategy implements MoveStrategy {
    private final boolean movable;

    public TestMoveStrategy(boolean movable) {
        this.movable = movable;
    }

    @Override
    public boolean isMovable() {
        return movable;
    }
}
