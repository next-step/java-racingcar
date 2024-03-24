package step5.domain;

import step5.domain.result.CarMovementResult;

public class Car {
    private final CarName name;
    private int moveCount;

    public static Car withName(String name) {
        return new Car(name);
    }

    private Car(String name) {
        this.name = new CarName(name);
    }

    public CarMovementResult move(Moving movingStrategy) {
        if (movingStrategy.movable()) {
            moveCount++;
        }
        return new CarMovementResult(name, moveCount);
    }

}
