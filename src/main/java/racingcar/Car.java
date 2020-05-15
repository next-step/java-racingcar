package racingcar;

import racingcar.exception.ErrorMessage;
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
        validateMovingStrategy(movingStrategy);
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    private void validateMovingStrategy(final MovingStrategy movingStrategy) {
        if (movingStrategy == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PARAMETER);
        }
    }

    public int getPosition() {
        return this.position;
    }
}
