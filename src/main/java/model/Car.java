package model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Position position;
    private final Name name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            return new Car(name, position.move());
        }

        return new Car(name, new Position(getPosition()));
    }

    public boolean isSamePosition(Position other) {
        return this.position.equals(other);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public int compareTo(Car other) {
        return other.position.compareTo(this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
