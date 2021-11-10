package racingcar;

import racingcar.collection.CarName;
import racingcar.collection.Position;
import racingcar.model.MoveResultDto;
import racingcar.strategy.MoveStrategy;

public class Car {
    private final MoveStrategy moveStrategy;

    private final CarName name;
    private final Position currentPosition = new Position();

    public Car(CarName name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public Position move() {
        if (isMovable()) {
            movePosition();
        }
        return currentPosition;
    }

    public CarName getName() {
        return name;
    }

    public MoveResultDto getMoveResultDto() {
        return new MoveResultDto(this.name, this.currentPosition);
    }

    public int getCurrentPositionValue() {
        return currentPosition.getPosition();
    }

    public boolean currentPositionEqualsTo(int position) {
        return this.currentPosition.getPosition() == position;
    }

    private void movePosition() {
        this.currentPosition.increasePosition();
    }

    private boolean isMovable() {
        return moveStrategy.strategicMove();
    }
}
