package step3.model;

import step3.strategy.MoveStrategy;

public class Car {
    private Integer position;

    public Integer getPosition() {
        return position;
    }

    public Car() {
        this.position = 0;
    }

    public void movable(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position++;
        }
    }
}
