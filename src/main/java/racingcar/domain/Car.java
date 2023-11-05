package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public int getPosition() {
        return this.position.getNumber();
    }

    public void move(MoveStrategy moveStrategy) {
        this.position.move(moveStrategy.moveCondition());
    }
}
