package study.step4.domain;

import study.step4.domain.strategy.MoveStrategy;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;
    private final MoveStrategy moveStrategy;

    public Car(CarName carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.carPosition = new CarPosition();
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if(moveStrategy.isMovable())
            carPosition.forward();
    }
}
