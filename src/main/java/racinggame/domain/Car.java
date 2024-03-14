package racinggame.domain;

import java.util.Objects;

public class Car {
    private Position position;

    public Car() {
        this.position = Position.create();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMoving()) {
            position = position.move();
        }
    }

    public Position getPosition() {
        return this.position;
    }
}
