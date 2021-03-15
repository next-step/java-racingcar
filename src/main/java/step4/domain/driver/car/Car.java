package step4.domain.driver.car;

import step4.domain.startegy.move.MoveStrategy;

public class Car {

    private int INITIAL_VALUE = 0;
    private int status;

    public static Car newInstance() {
        return new Car();
    }

    public static Car of(Car other) {
        return new Car(other);
    }

    private Car() {
        status = INITIAL_VALUE;
    }

    private Car(Car other) {
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
