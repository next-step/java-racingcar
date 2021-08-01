package racingcar.domain;

import java.util.Objects;

public class Car {
    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(MovableStrategy movable) {
        if (movable.canMove()) {
            position = new Position(position.getPosition() + 1);
        }
    }

    public Position getPosition() {
        return position;
    }


    public boolean isSame(Position position) {
        return Objects.equals(this.position, position);
    }
}
