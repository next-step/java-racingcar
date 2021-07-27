package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(CarName carName) {
        this(carName, new CarPosition());
    }

    public Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            carPosition.increase();
        }
    }

    public boolean hasSamePositionWith(Car car) {
        return carPosition.equals(car.carPosition);
    }

    public String getName() {
        return carName.getName();
    }

    public int getCarPosition() {
        return carPosition.getPosition();
    }

}
