package step4.domain.driver.car;

import step4.domain.startegy.move.MoveStrategy;

public class Car {

    private int INITIAL_VALUE = 0;
    private int status;

    public Car() {
        status = INITIAL_VALUE;
    }

    public Car(Car other) {
        this.status = other.status;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            status++;
        }
    }

    public int getStatus() {
        return status;
    }

}
