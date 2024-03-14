package racingcar.domain;

import racingcar.domain.strategyPattern.MoveStrategy;

public class Car {
    private static final int MIN_MOVE_COUNT = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }
}
