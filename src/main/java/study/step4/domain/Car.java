package study.step4.domain;

import study.step4.domain.strategy.MoveStrategy;

import java.util.Comparator;

public class Car {
    private final CarName carName;
    private CarPosition carPosition;

    public Car(CarName carName) {
        this.carName = carName;
        this.carPosition = CarPosition.createDefault();
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMovable()) {
            carPosition = carPosition.forward();
        }
    }

    public String name() {
        return carName.getCarName();
    }

    public int position() {
        return carPosition.getPosition();
    }

    public boolean equalPosition(Car car) {
        return this.position() == car.position();
    }
}
