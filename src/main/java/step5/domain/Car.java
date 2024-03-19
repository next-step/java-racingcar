package step5.domain;

import step5.view.result.CarMovementResult;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;
    private int moveCount;

    public static Car withName(String name) {
        return new Car(name);
    }

    private Car(String name) {
        assertNameLengthUnderFive(name);
        this.name = name;
    }

    private void assertNameLengthUnderFive(String name) {
        if (CAR_NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(Moving movingStrategy) {
        if (movingStrategy.movable()) {
            moveCount++;
        }
    }

    public CarMovementResult movementResult() {
        return new CarMovementResult(name, moveCount);
    }

}
