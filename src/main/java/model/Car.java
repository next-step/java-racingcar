package model;

import strategy.MoveStrategy;
import strategy.RandomMoveStrategy;

public class Car {
    private final CarName carName;
    private int currentPosition = 1;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.carName = new CarName(name);

        if (moveStrategy == null) {
            moveStrategy = new RandomMoveStrategy();
        }

        this.moveStrategy = moveStrategy;
    }


    // 테스트용
    public Car(String name, int position) {
        this(name, null);
        this.currentPosition = position;
    }

    public void tryMove() {
        if (moveStrategy.canMove()) {
            this.currentPosition++;
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public String getCarName() {
        return this.carName.getCarName();
    }
}
