package racingcar;

import java.util.Random;

public class Car {

    private int position;

    private MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        position = 0;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
