package step3.domain;

import step3.view.result.CarMovementResult;

public class Car {
    private int moveCount;

    public void move(Moving movingStrategy) {
        if (movingStrategy.movable()) {
            moveCount++;
        }
    }

    public CarMovementResult movementResult() {
        return CarMovementResult.from(moveCount);
    }

}
