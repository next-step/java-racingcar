package step5.racingcar3.domain;

import step5.racingcar3.exception.PositiveNumberException;

public class PositiveNumber {

    public static final int MIN_VALUE = 1;
    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new PositiveNumberException(String.format("%d 이상의 정수만 가능합니다.", MIN_VALUE));
        }
    }

    public int value() {
        return value;
    }

}
