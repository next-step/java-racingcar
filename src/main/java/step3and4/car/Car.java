package step3and4.car;

import step3and4.car.move.MoveStrategy;

public class Car {
    private int position = 0;
    private String carName;
    private MoveStrategy moveStrategy;

    public Car(String carName, MoveStrategy moveStrategy) {
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
