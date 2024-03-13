package racingcar.domain;

import java.util.Objects;

public class Car {

    private Position position;

    public Car(Position position) {
        this.position = position;
    }

    public Car() {
        this(new Position());
    }

    public Car(int step) {
        this(new Position(step));
    }

    public Car move() {
        Position movedPosition = this.position.moveOneStep();
        return new Car(movedPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
