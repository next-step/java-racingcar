package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private CarName carName;
    private Position position;

    public Car(CarName carName) {
        this(carName, new Position());
    }

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            this.position = position.move();
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position.getSteps();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

    @Override
    public int compareTo(Car anotherCar) {
        return position.compareTo(anotherCar.position);
    }
}
