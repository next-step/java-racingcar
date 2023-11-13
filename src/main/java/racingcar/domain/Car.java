package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

    private Position position;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
        position = new Position();
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.ableMove()) {
            position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String carName() {
        return carName;
    }

    public boolean matchPosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }
}
