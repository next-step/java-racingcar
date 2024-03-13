package step4.domain;

import step4.view.result.CarMovementResult;

public class Car {
    private final String name;
    private int moveCount;

    public static Car withName(String name) {
        return new Car(name);
    }

    private Car(String name) {
        this.name = name;
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
