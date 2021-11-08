package racingcar;

import racingcar.collection.CarPosition;
import racingcar.exception.TooLongCarNameException;
import racingcar.strategy.MoveStrategy;

public class Car {
    private final MoveStrategy moveStrategy;

    private final String name;
    private final CarPosition currentPosition = new CarPosition();

    public Car(String name, MoveStrategy moveStrategy) {
        if (name.length() > 5) {
            throw new TooLongCarNameException();
        }
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public CarPosition move() {
        if (isMovable()) {
            movePosition();
        }
        return currentPosition;
    }

    public String getName() {
        return name;
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
