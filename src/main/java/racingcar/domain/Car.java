package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(final MoveStrategy moveStrategy) {
        this.position += moveStrategy.moveCondition();
    }
}
