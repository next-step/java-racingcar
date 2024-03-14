package racinggame.domain;

import java.util.Objects;

public class Car {

    private Position position;
    private CarName name;

    public Car(CarName name) {
        this(new Position(), name);
    }

    public Car(Position position, CarName name) {
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
        return name.value();
    }

    public Car copy() {
        return new Car(position, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position.getPosition(), car.position.getPosition())
                && Objects.equals(name.value(), car.name.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position.getPosition(), name.value());
    }

    public boolean isPassed(Position winnerPosition) {
        return position.compareTo(winnerPosition) >= 0;
    }
}
