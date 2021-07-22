package racingcar.car;

import racingcar.strategy.MoveStrategy;

public class Car {

    private int position;

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
