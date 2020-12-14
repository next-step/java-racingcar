package study.racingcar.domain;

import java.util.Objects;

public class Car {

    private final Position position;
    private final Name name;

    public Car(String name) {
        this.position = new Position();
        this.name = new Name(name) {
        };
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public int compare(Car car) {
        return this.position.compare(car.position);
    }

    public Name getName() {
        return name;
    }

    public boolean matchPosition(Position positionNum) {
        return position.equals(positionNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(position, car.position) &&
            Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return "Car{" +
            "position=" + position +
            ", name=" + name +
            '}';
    }
}
