package racingcar.domain;

import racingcar.domain.input.CarName;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMoving;

import java.util.Objects;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private int position;
    private final CarName carName;
    private final MovingStrategy strategy;

    public Car(String carName) {
        this(new CarName(carName), new RandomMoving(), INITIAL_POSITION);
    }

    public Car(CarName carName) {
        this(carName, new RandomMoving(), INITIAL_POSITION);
    }

    public Car(String carName, int position) {
        this(new CarName(carName), new RandomMoving(), position);
    }

    public Car(String carName, MovingStrategy strategy) {
        this(new CarName(carName), strategy, INITIAL_POSITION);
    }

    public Car(CarName carName, MovingStrategy strategy, int position) {
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
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isTop(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName) && Objects.equals(strategy, car.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, carName, strategy);
    }
}
