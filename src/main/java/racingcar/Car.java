package racingcar;

import racingcar.moving.MovingStrategy;

public class Car {

    static final int DEFAULT_DISTANCE = 0;
    private int position;

    static Car newInstance() {
        return new Car();
    }

    private Car() {
        this.position = DEFAULT_DISTANCE;
    }

    void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
