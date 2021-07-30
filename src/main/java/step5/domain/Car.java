package step5.domain;

import step5.strategy.MovingStrategy;

public class Car {

    private static final int LIMIT_NAME_LENGTH = 5;

    private final String name;
    private final MovingStrategy movingStrategy;
    private final CarEngine engine;

    private int movedCount = 0;


    public Car(String name, CarEngine engine, MovingStrategy movingStrategy) {
        checkNameLength(name);
        this.name = name;
        this.engine = engine;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (!engine.canMove(movingStrategy.move())) {
            return;
        }

        this.movedCount++;
    }

    public String getName() {
        return name;
    }

    public int getMovedCount() {
        return movedCount;
    }

    private void checkNameLength(String carName) {
        if (carName.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자리 초과 할 수 없습니다.");
        }
    }
}
