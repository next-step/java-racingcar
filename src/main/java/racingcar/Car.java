package racingcar;

import racingcar.collection.CarPosition;
import racingcar.strategy.MoveStrategy;

public class Car {
    private final MoveStrategy moveStrategy;

    private CarPosition currentPosition = new CarPosition();

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public CarPosition move() {
        if (isMovable()) {
            movePosition();
        }
        return currentPosition;
    }

    public CarPosition getCurrentPosition() {
        return currentPosition;
    }

    private void movePosition() {
        this.currentPosition.increasePosition();
    }

    private boolean isMovable() {
        return moveStrategy.strategicMove();
    }
}
