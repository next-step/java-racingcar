package model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Position position;
    private final Name name;
    private final MoveStrategy moveStrategy;

    public Car(String name) {
        this(name, new RandomMove());
    }

    public Car(String name, int position) {
        this(name, position, new RandomMove());
    }

    public Car(String name, MoveStrategy moveStrategy) {
        this(name, 0, moveStrategy);
    }

    public Car(String name, int position, MoveStrategy strategy) {
        this(new Name(name), new Position(position), strategy);
    }

    public Car(Name name, Position position, MoveStrategy strategy) {
        this.name = name;
        this.position = position;
        this.moveStrategy = strategy;
    }

    public Car move() {
        if (moveStrategy.movable()) {
            return new Car(name, position.move(), moveStrategy);
        }

        return new Car(name, new Position(getPosition()), moveStrategy);
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
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Car car = (Car) other;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name) && Objects.equals(moveStrategy, car.moveStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name, moveStrategy);
    }

}
