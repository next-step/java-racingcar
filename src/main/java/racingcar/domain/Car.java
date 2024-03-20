package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isWinner(int comparisonPosition) {
        return this.position >= comparisonPosition;
    }
}
