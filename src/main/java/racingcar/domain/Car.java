package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_MOVEMENT_DISTANCE = 1;

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String name() {
        return name.name();
    }


    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public int positionValue() {
        return position.getPosition();
    }

    public Position position() {
        return position;
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            Position newPosition = position.add(DEFAULT_MOVEMENT_DISTANCE);
            return new Car(name, newPosition);
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
