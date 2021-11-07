package racingcar;

import racingcar.strategy.MoveStrategy;

public class Car {
    private final MoveStrategy moveStrategy;

    private int currentPosition = 0;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int move() {
        if (isMovable()) {
            movePosition();
        }
        return currentPosition;
    }

    private void movePosition() {
        this.currentPosition++;
    }

    private boolean isMovable() {
        return moveStrategy.strategicMove();
    }
}
