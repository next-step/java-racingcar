package racingcar;

import static java.text.MessageFormat.format;

public class Car {

    private static final String INVALID_CAR_NUMBER_MESSAGE = "자동차의 번호는 자연수만 가능합니다. [number : {0}]";
    private static final int ZERO = 0;

    private final int number;

    private Car(final int number) {
        validateNumberIsPositive(number);

        this.number = number;
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

    public static Car from(final int number) {
        return new Car(number);
    }
}
