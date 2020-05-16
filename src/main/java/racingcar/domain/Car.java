package racingcar.domain;

import calculator.util.StringUtil;
import racingcar.exception.ErrorMessage;
import racingcar.moving.MovingStrategy;

public class Car {

    public static final int DEFAULT_DISTANCE = 0;

    private String name;
    private int position;

    private Car() {
    }

    private Car(final String name) {
        validate(name);
        this.position = DEFAULT_DISTANCE;
        this.name = name;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    private static void validate(final String value) {
        if (StringUtil.isEmpty(value)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
    }

    public void move(final MovingStrategy movingStrategy) {
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

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
