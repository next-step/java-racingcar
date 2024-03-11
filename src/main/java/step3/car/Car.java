package step3.car;

import step3.car.move.MoveStrategy;

public class Car {
    private int position = 0;
    private MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            position += moveStrategy.move();
        }
    }

    public int getPosition() {
        return this.position;
    }
}
