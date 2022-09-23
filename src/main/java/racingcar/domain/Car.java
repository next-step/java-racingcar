package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int DEFAULT_MOVEMENT_DISTANCE = 1;

    private Name name;
    private Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        this(new Name(name), position);
    }

    public Car(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String name() {
        return name.value();
    }

    public boolean isSameCondition(Car other) {
        return this.position.equals(other.position);
    }

    public int positionValue() {
        return position.getValue();
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

    @Override
    public int compareTo(Car o) {
        return positionValue() - o.positionValue();
    }
}
