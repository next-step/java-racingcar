package racingcar;

import calculator.util.StringUtil;
import racingcar.exception.ErrorMessage;
import racingcar.moving.MovingStrategy;

public class Car {

    static final int DEFAULT_DISTANCE = 0;

    private String name;
    private int position;

    private Car() {
    }

    private Car(final String name) {
        this.position = DEFAULT_DISTANCE;
        this.name = name;
    }

    public static Car of(final String name) {
        validateName(name);
        return new Car(name);
    }

    private static void validateName(String name) {
        if (StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
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

    public String getName() {
        return this.name;
    }
}
