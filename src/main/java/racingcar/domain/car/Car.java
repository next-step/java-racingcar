package racingcar.domain.car;

import java.util.Objects;

import racingcar.domain.movement.MovementStrategy;

public class Car {

    public static final int SPEED = 1;
    private static final int START_POSITION = 0;

    private final Name name;
    private final Position position;

    private Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(final String name, final int position) {
        this(new Name(name), new Position(position));
    }

    public Name name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }

    public boolean equalsPosition(final Position position) {
        return this.position.equals(position);
    }

    public void moveForwardOrStop(final MovementStrategy movementStrategy) {
        if (movementStrategy.canMoveForward()) {
            this.position.increase(SPEED);
        }
    }

    public Car copyOf() {
        return new Car(this.name.copyOf(), this.position.copyOf());
    }

    public static Car from(final String carName) {
        return new Car(Name.from(carName), new Position(START_POSITION));
    }

    @Override
    public boolean equals(final Object otherCar) {
        if (this == otherCar) {
            return true;
        }

        if (otherCar == null || getClass() != otherCar.getClass()) {
            return false;
        }

        final Name otherCarName = ((Car)otherCar).name;
        final Position otherCarPosition = ((Car)otherCar).position;

        return this.name.equals(otherCarName) && this.position.equals(otherCarPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
