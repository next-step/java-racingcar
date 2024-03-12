package step3.service;

import step3.view.CarMovementResult;

public class Car {
    private final Moving movingStrategy;
    private int moveCount;

    public static Car randomMovingCar() {
        return new Car(new RandomMoving());
    }

    private Car(Moving movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.movable()) {
            moveCount++;
        }
    }

    public CarMovementResult movementResult() {
        return CarMovementResult.from(moveCount);
    }

}
