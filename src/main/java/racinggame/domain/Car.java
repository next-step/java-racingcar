package racinggame.domain;

import java.util.Objects;

public class Car {
    private static final int FORWARD_NUM = 4;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_NUM)
            this.position = position.increase();
    }

    public Position max(Position other) {
        return this.position.max(other);
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
