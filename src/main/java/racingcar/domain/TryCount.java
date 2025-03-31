package racingcar.domain;

import racingcar.message.ErrorMessages;

public class TryCount {
    private final int tryCount;

    public TryCount(String input) {
        validateStringIsNumber(input);
        isValidNumber(input);
        this.tryCount = Integer.parseInt(input);
    }

    public boolean isNotSame(int tryCount) {
        return this.tryCount != tryCount;
    }

    private void validateStringIsNumber(String input) {
        if (!input.matches("[0-9]")) {
            throw new IllegalArgumentException(ErrorMessages.TRY_COUNT_NOT_NUMBER);
        }
    }

    private void isValidNumber(String input) {
        long count = Long.parseLong(input);
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessages.TRY_COUNT_NOT_VALID_NUMBER);
        }
    }
}
