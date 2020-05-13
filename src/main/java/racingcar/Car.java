package racingcar;

import racingcar.moving.MovingStrategy;

public class Car {

    private static final int DEFAULT_DISTANCE = 0;
    private int position;

    static Car of() {
        return new Car();
    }

    private Car() {
        this.position = DEFAULT_DISTANCE;
    }

    void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.move()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
