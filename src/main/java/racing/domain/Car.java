package racing.domain;

import java.util.Objects;

public class Car {
    private Position position;
    private Name name;

    public Car(String name) {
        this.position = new Position(0);
        this.name = new Name(name);
    }

    public Position getPosition() {
        return this.position;
    }

    public Position getFarthestPosition(Position position) {
        return this.position.max(position);
    }

    public void go() {
        this.position = this.position.increase();
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
