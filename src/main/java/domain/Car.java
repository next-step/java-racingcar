package domain;

import strategy.MoveStrategy;
import strategy.RandomMoveStrategy;

public class Car {
    private final CarName carName;
    private int currentPosition = 1;
    private MoveStrategy moveStrategy;

    public Car(String name){
        this.carName = new CarName(name);
        moveStrategy = new RandomMoveStrategy();
    }

    public Car(String name, MoveStrategy moveStrategy) {
        this(name);
        this.moveStrategy = moveStrategy;
    }

    // 테스트용
    public Car(String name, int position) {
        this(name);
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
