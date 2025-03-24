package model;

import strategy.MoveStrategy;
import strategy.RandomMoveStrategy;

public class Car {
    private final String name;
    private int currentPosition = 1;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        if (name.length() > 5) {
            throw new RuntimeException("name은 5자를 초과할 수 없습니다. name :" + name);
        }

        this.name = name;

        if (moveStrategy == null) {
            moveStrategy = new RandomMoveStrategy();
        }

        this.moveStrategy = moveStrategy;
    }

    public void tryMove() {
        if (moveStrategy.canMove()) {
            this.currentPosition++;
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public String getName() {
        return this.name;
    }
}
