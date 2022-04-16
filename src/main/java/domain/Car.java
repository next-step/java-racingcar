package domain;

import util.MoveStrategy;

public class Car {
    private final Position position;

    public Car() {
        position = new Position();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.goForward();
        }
    }

    public Position getPosition() {
        return position;
    }
}
