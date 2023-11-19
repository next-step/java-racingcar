package calculator;

import java.util.Objects;

public class PositiveNumber {
    public static final String NOT_POSITIVE_NUMBER_EXCEPTION = "숫자가 음수입니다. 숫자는 양수만 가능합니다.";
    public static final String NOT_NUMBER_EXCEPTION = "값이 숫자가 아닙니다. 숫자를 입력해주세요.";
    private final long number;

    public PositiveNumber(String value) {
        long number = parseToNumber(value);

        if (isMinus(number)) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_EXCEPTION);
        }
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

    private boolean isMinus(long number) {
        return number < 0;
    }

    public PositiveNumber plus(PositiveNumber number) {
        return new PositiveNumber(String.valueOf(this.number + number.number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber number1 = (PositiveNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
