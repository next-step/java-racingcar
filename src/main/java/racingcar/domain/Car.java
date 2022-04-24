package racingcar.domain;

import racingcar.domain.input.CarName;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMoving;

import java.util.Objects;

public class Car {

    private final Position position;
    private final CarName carName;
    private final MovingStrategy strategy;

    public Car(String carName) {
        this(new CarName(carName), new RandomMoving(), new Position());
    }

    public Car(CarName carName) {
        this(carName, new RandomMoving(), new Position());
    }

    public Car(String carName, int position) {
        this(new CarName(carName), new RandomMoving(), position);
    }

    public Car(String carName, MovingStrategy strategy) {
        this(new CarName(carName), strategy, new Position());
    }

    public Car(String carName, MovingStrategy strategy, int position) {
        this(new CarName(carName), strategy, new Position(position));
    }

    public Car(CarName carName, MovingStrategy strategy, int position) {
        this(carName, strategy, new Position(position));
    }

    public Car(CarName carName, MovingStrategy strategy, Position position) {
        this.position = position;
        this.carName = carName;
        this.strategy = strategy;
    }

    public Car(Car car) {
        this.position = car.position;
        this.carName = car.carName;
        this.strategy = car.strategy;
    }

    public void move() {
        if (!strategy.isMoving()) {
            return;
        }
        go();
    }

    private void go() {
        position.up();
    }

    public boolean isTop(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    public int compareMaxPosition(int maxPosition) {
        return position.compareToMax(maxPosition);
    }

    public Position position() {
        return position;
    }

    public CarName carName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, carName);
    }
}
