package racing.domain;

import racing.strategy.MoveStrategy;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
