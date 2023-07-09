package racingcar.domain;

import racingcar.exception.TryCountInputException;

public class TryCount {

    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String NUMBER_MESSAGE = "숫자만 입력받을 수 있습니다.";
    private final int value;

    TryCount(int value) {
        this(String.valueOf(value));
    }

    public TryCount(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        if (value == null || value.isBlank() || !value.matches(NUMBER_REGEX)) {
            throw new TryCountInputException(NUMBER_MESSAGE);
        }
    }

    public boolean isZero() {
        return this.value == 0;
    }

    public TryCount decrease() {
        return new TryCount(this.value - 1);
    }
}
