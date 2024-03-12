package step3.service;

import step3.view.result.CarMovementResult;

public class Car {
    private int moveCount;

    public Car() {
    }

    public void move(Moving movingStrategy) {
        if (movingStrategy.movable()) {
            moveCount++;
        }
    }

    public CarMovementResult movementResult() {
        return CarMovementResult.from(moveCount);
    }

}
