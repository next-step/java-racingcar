package racingcar.domain;

public class PositiveNumber {
    public static final String NOT_NUMBER_EXCEPTION = "값이 숫자가 아닙니다. 숫자만 입력할 수 있습니다.";
    public static final String NOT_POSITIVE_NUMBER_EXCEPTION = "숫자가 음수입니다. 숫자는 양수만 입력할 수 있습니다.";
    private final long number;

    public PositiveNumber(String value) {
        long number = parseToNumber(value);
        validatePositiveNumber(number);
        this.number = number;
    }

    private long parseToNumber(String value) {
        long number;
        try {
            number = Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }
        return number;
    }

    private void validatePositiveNumber(long number) {
        if (isMinus(number)) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_EXCEPTION);
        }
    }

    private boolean isMinus(long number) {
        return number < 0;
    }

    public long getNumber() {
        return number;
    }
}
