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

    public Name getName() {
        return name;
    }

    public boolean isSame(Position position) {
        return Objects.equals(this.position, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
