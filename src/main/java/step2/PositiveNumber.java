package step2;

import java.util.Objects;

public class PositiveNumber {

    private final int number;

    public PositiveNumber(String value) {
        this(Integer.parseInt(value));
    }

    public PositiveNumber(int number) {
        checkPositive(number);
        this.number = number;
    }

    public static int toPositiveNumber(String value) {
        int number = Integer.parseInt(value);
        checkPositive(number);
        return number;
    }

    private static void checkPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수값이 들어올 수 없습니다.");
        }
    }

    public PositiveNumber plus(PositiveNumber number) {
        return new PositiveNumber(this.number + number.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positiveNumber = (PositiveNumber) o;
        return number == positiveNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
