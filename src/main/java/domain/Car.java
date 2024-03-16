package domain;

import java.util.Objects;

public class Car {

    private final Name name;
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this(Name.createDefaultInstance(), moveStrategy);
    }

    public Car(Name name, MoveStrategy moveStrategy) {
        this(name, new Position(), moveStrategy);
    }

    public Car(String name, int position, MoveStrategy moveStrategy) {
        this(new Name(name), new Position(position), moveStrategy);
    }

    public Car(Name name, Position position, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.moveable()) {
            position.moveForward();
        }
    }

    public Position position() {
        return this.position;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name.value(), "-".repeat(position.getValue() + 1));
    }

    public Name name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position) &&
                moveStrategy.moveable() == car.moveStrategy.moveable();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, moveStrategy.moveable());
    }
}
