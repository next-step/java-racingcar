package study.racinggame.domain;

import study.racinggame.domain.strategy.MoveStrategy;
import study.racinggame.domain.strategy.RandomMoveStrategy;

public class Car {
    private int position;

    private final MoveStrategy moveStrategy;

    public Car() {
        this.moveStrategy = new RandomMoveStrategy();
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            this.position++;
        }
    }
}
