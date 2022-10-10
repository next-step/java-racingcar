package racingcar.backend.domain;

import racingcar.backend.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private CarName carName;
    private Position position;

    public Car(final CarName carName, final Position position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car create(final CarName carName) {
        return new Car(carName, Position.create(0));
    }

    public static Car create(final CarName carName, final Position position) {
        return new Car(carName, position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position = position.forward();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public CarName getName() {
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, getPosition());
    }
}
