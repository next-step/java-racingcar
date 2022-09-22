package calculator;

import java.util.Objects;

public class PositiveNumber {
    private static final String NEGATIVE_EXCEPTION_MESSAGE = "음수는 입력할 수 없습니다.";

    private final int number;

    public PositiveNumber(int number) {
        validate(number);

        this.number = number;
    }

    public PositiveNumber(String number) {
        this(Integer.parseInt(number));
    }

    private void validate(int number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException(NEGATIVE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    public PositiveNumber add(PositiveNumber other) {
        return new PositiveNumber(this.number + other.number());
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof PositiveNumber)) {
            return false;
        }

        PositiveNumber that = (PositiveNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
