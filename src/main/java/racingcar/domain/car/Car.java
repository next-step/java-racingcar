package racingcar.domain.car;

import racingcar.domain.game.strategy.MoveStrategy;

public class Car {
    private static final int DEFAULT_MOVE_POSITION = 1;
    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position.move(DEFAULT_MOVE_POSITION);
        }
    }
}
