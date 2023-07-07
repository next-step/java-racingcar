package racing.domain;

import java.util.Objects;

public class Car {
    private static final int MOVING_RANGE_LOW = 4;
    private static final int MOVING_RANGE_HIGH = 9;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name), new Position());
    }

    public Car(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car goForward(int trigger) {
        if (isMovable(trigger)) {
            return new Car(this.name, this.position.next());
        }
        return this;
    }

    private boolean isMovable(int value) {
        return MOVING_RANGE_LOW <= value && value <= MOVING_RANGE_HIGH;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
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

    public boolean isSamePosition(Car other) {
        return this.position.equals(other.position);
    }

    public Car getWinnerAgainst(Car other) {
        if (this.position.compareTo(other.position) >= 0) {
            return this;
        }
        return other;
    }
}
