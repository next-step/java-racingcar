package domain;

import util.MoveStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private final Position position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.goForward();
        }
    }

    public boolean isEqualPosition(Car otherCar) {
        return position.equals(otherCar.position);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
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
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
