package carracing;

import java.util.Objects;

public class Car {
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position = position.move();
        }
        return this;
    }

    public boolean isFartherThan(Car other) {
        return this.position.isBiggerThan(other.position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
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
