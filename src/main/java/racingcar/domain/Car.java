package racingcar.domain;

import static java.text.MessageFormat.format;

public class Car {

    private static final String CAR_NUMBER_OUT_OF_RANGE_MESSAGE = "자동차의 번호는 자연수만 가능합니다. [number : {0}]";
    private static final int START_POSITION = 0;
    private static final int MINIMUM_CAR_NUMBER = 1;
    private static final int SPEED = 1;

    private final int number;
    private int position;

    public Car(final int number) {
        validateCarNumberIsInRange(number);

        this.number = number;
        this.position = START_POSITION;
    }

    private void validateCarNumberIsInRange(final int number) {
        if (isCarNumberOutOfRange(number)) {
            throw new IllegalArgumentException(format(CAR_NUMBER_OUT_OF_RANGE_MESSAGE, number));
        }
    }

    private boolean isCarNumberOutOfRange(final int number) {
        return number < MINIMUM_CAR_NUMBER;
    }

    public int number() {
        return this.number;
    }

    public int position() {
        return this.position;
    }

    public void moveForwardOrStop(final CarMovement carMovement) {
        if (carMovement.movable()) {
            moveForward();
        }
    }

    private void moveForward() {
        this.position += SPEED;
    }
}
