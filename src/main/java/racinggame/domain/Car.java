package racinggame.domain;

import java.util.Objects;

public class Car {

    private Position position;
    private String name;

    public Car(String name) {
        this(new Position(), name);
    }

    public Car(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public void run(MoveCondition condition) {
        if (condition.isMovable()) {
            position = position.add();
        }
    }

    public Position position() {
        return position;
    }

    public String name() {
        return name;
    }

    public Car copy() {
        return new Car(position, name);
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
