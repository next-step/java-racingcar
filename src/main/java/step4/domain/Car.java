package step4.domain;

import step4.view.result.CarMovementResult;

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
