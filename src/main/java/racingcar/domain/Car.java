package racingcar.domain;

import racingcar.generator.NumberGenerator;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private MovementCount movementCount;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.movementCount = new MovementCount();
    }

    public Car(String carName, int movementCount) {
        this.carName = new CarName(carName);
        this.movementCount = new MovementCount(movementCount);
    }

    public int getMovementCount() {
        return movementCount.getMovementCount();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public void move(NumberGenerator numberGenerator) {
        movementCount.move(numberGenerator);
    }

    public boolean isWinnerMovementCount(int movementCount) {
        return this.movementCount.isWinnerMovementCount(movementCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName.getCarName(), car.carName.getCarName())
                && Objects.equals(movementCount.getMovementCount(), car.movementCount.getMovementCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, movementCount);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName=" + carName +
                ", movementCount=" + movementCount +
                '}';
    }
}
