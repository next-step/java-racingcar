package calculator;

import java.util.Objects;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(String token) {
        this(parseInt(token));
    }

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    public PositiveNumber() {
        this(0);
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static int parseInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public PositiveNumber plus(PositiveNumber positiveNumber) {
        return new PositiveNumber(this.value + positiveNumber.value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
