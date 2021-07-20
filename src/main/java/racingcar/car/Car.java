package racingcar.car;

import racingcar.strategy.MoveStrategy;

public class Car {
    private int position;

    private Car() {
        this.position = 0;
    }

    public static Car newInstance() {
        return new Car();
    }

    public int currentPosition() {
        return position;
    }

    // move(MoveStrategy moveStrategy); 같은 방식은 어떨까..?
    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }
}
