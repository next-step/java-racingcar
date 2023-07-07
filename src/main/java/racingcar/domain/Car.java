package racingcar.domain;

import java.util.Objects;

public class Car {
    private final Name name;

    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(final MoveStrategy strategy) {
        final int amount = strategy.amount();
        this.position = position.move(amount);
    }

    public boolean isSamePositionWith(final Car car) {
        return this.getPositionDifferenceWith(car) == 0;
    }

    public int getPositionDifferenceWith(final Car car) {
        return this.position.getDifferenceWith(car.position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Car car = (Car) other;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
