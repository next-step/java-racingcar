package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(int position) {
        this.position = position;
    }

    public Car move(MoveStrategy strategy) {
        if (strategy.moveCar()) {
            return new Car(position + 1);
        }
        return new Car(position);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
