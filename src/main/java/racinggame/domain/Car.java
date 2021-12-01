package racinggame.domain;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this(new Name(name), Position.of(position));
    }

    public Car(final String name, final Position position) {
        this(new Name(name), position);
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Car movedCar(RandomValue randomValue) {
        if (randomValue.isMovable())
            return new Car(this.name, this.position.movedPosition());
        return this;
    }

    public Position maxPosition(Position maxPosition) {
        if (this.position.isBiggerThan(maxPosition)) {
            return this.position;
        }
        return maxPosition;
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
