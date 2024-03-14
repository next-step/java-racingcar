package racinggame.domain;

import java.util.Objects;

public class Car {
    private Position position;
    private Name name;

    public Car(String name) {
        this.name = Name.create(name);
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
