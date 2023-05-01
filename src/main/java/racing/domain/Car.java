package racing.domain;

import java.util.Objects;

public class Car {
    private Position position;
    private final Name name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void go(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            this.position = this.position.increase();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public Position getFarthestPosition(Position position) {
        return this.position.max(position);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
