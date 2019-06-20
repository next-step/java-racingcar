package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private final Position position;

    private Car(CarName carName, Position position) {
        AssertUtils.notNull(carName, "'carName' must not be null");
        AssertUtils.notNull(position, "'position' must not be null");

        this.carName = carName;
        this.position = position;
    }

    public static Car from(CarName carName) {
        final Position origin = Position.origin();
        return new Car(carName, origin);
    }

    public CarName getName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isLocatedAt(Position position) {
        return this.position.equals(position);
    }

    public Car move(int distance) {
        final Position movedPosition = position.add(distance);
        return new Car(carName, movedPosition);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName=" + carName +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carName.equals(car.carName) &&
                position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
