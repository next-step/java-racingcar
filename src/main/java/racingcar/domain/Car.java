package racingcar.domain;

import racingcar.behavior.MovingStrategy;

public class Car {
    static final int DEFAULT_DISTANCE = 0;

    private int position;

    public Car() {
        this.position = DEFAULT_DISTANCE;
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}