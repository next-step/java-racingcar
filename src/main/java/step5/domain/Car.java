package step5.domain;

import step5.domain.result.CarMovementResult;

public class Car {
    private final CarName name;
    private final MoveCount moveCount;

    public static Car withName(String name) {
        return new Car(name);
    }

    private Car(String name) {
        this.name = new CarName(name);
        this.moveCount = new MoveCount();
    }

    public CarMovementResult move(Moving movingStrategy) {
        if (movingStrategy.movable()) {
            moveCount.increase();
        }
        return new CarMovementResult(name, moveCount);
    }

}
