package racingcar.domain;

import static java.text.MessageFormat.format;

public class Car {

    private static final String INVALID_CAR_NUMBER_MESSAGE = "자동차의 번호는 자연수만 가능합니다. [number : {0}]";
    private static final String MOVING_CONDITION_OUT_OF_RANGE_MESSAGE = "자동차의 전진/정지 조건은 0이상 9이하의 자연수만 가능합니다. [condition : {0}]";

    private static final int START_POSITION = 0;
    private static final int ZERO = 0;
    private static final int FORWARD = 1;
    private static final int FORWARD_CONDITION_RANGE_START = 4;
    private static final int MOVING_CONDITION_RANGE_START = 0;
    private static final int MOVING_CONDITION_RANGE_END = 9;

    private final int number;
    private int position;

    public Car(final int number) {
        validateNumberIsPositive(number);

        this.number = number;
        this.position = START_POSITION;
    }

    private void validateNumberIsPositive(final int number) {
        if (isNegativeOrZero(number)) {
            throw new IllegalArgumentException(format(INVALID_CAR_NUMBER_MESSAGE, number));
        }
    }

    private boolean isNegativeOrZero(final int number) {
        return number <= ZERO;
    }

    public int number() {
        return this.number;
    }

    public int position() {
        return this.position;
    }

    public void moveForwardOrStop(final int condition) {
        validateConditionIsInRange(condition);

        if (canMoveForward(condition)) {
            this.position += FORWARD;
        }
    }

    private void validateConditionIsInRange(final int condition) {
        if (isConditionOutOfRange(condition)) {
            throw new IllegalArgumentException(format(MOVING_CONDITION_OUT_OF_RANGE_MESSAGE, condition));
        }
    }

    private boolean isConditionOutOfRange(final int condition) {
        return condition < MOVING_CONDITION_RANGE_START || condition > MOVING_CONDITION_RANGE_END;
    }

    private boolean canMoveForward(final int condition) {
        return condition >= FORWARD_CONDITION_RANGE_START;
    }
}
