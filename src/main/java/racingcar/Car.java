package racingcar;


import java.util.Random;

public class Car {
    private MoveStrategy moveStrategy = new FourOverTenMoveStrategy();
    private Integer position = 0;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void tryMove() {
        move(moveStrategy.isMovable());
    }

    private void move(boolean isMovable) {
        if (isMovable) {
            increasePosition();
        }
    }

    public Integer getPosition() {
        return this.position;
    }

    private void increasePosition() {
        this.position += 1;
    }
}
