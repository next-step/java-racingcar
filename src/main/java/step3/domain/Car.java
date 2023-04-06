package step3.domain;

import step3.strategy.MoveStrategy;

public class Car {

    private final MoveStrategy moveStrategy;
    private final Position position;

    private Car(MoveStrategy moveStrategy, Position position) {

        this.moveStrategy = moveStrategy;
        this.position = position;
    }

    public void move() {

        if (moveStrategy.isMovable()) {
            position.increase();
        }
    }

    public static Car Of(MoveStrategy moveStrategy, Position position) {

        return new Car(moveStrategy, position);
    }
}
