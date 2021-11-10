package step4.domain;

import step4.strategy.MoveStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car createWithDefaultPosition(Name name) {
        Position position = Position.withDefaultPosition();
        return new Car(name, position);
    }

    public static Car create(Name name, Position position) {
        return new Car(name, position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean equalsPosition(Car target) {
        return this.position.equals(target.position);
    }

    public Car moveOrStop(MoveStrategy moveStrategy) {
        Position now = this.position;
        if (moveStrategy.test()) {
            now = this.position.move();
        }
        return create(name, now);
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

    public String toStringNameAndPosition() {
        return name.toString() + " : " + position.toString();
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }
}
