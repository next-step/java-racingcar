package study.step4.domain;

import study.step4.domain.strategy.MoveStrategy;

public class Car {
    private static final int CAR_START_POSITION = 0;
    private final CarName carName;
    private CarPosition carPosition;
    private final MoveStrategy moveStrategy;

    public Car(CarName carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.carPosition = new CarPosition(CAR_START_POSITION);
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if(moveStrategy.isMovable())
            carPosition = carPosition.forward();
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    public int comparator() {
        return 0;
    }
}
