package calculator;

import java.util.Objects;

import static calculator.Calculator.PLUS;

public class PositiveNumber {
    private final int number;

    private PositiveNumber(int number) {
        this.number = number;
    }

    public static PositiveNumber of(String value) {
        int number = Integer.parseInt(value);
        checkPositive(number);
        return new PositiveNumber(number);
    }

    public static PositiveNumber of(int number) {
        checkPositive(number);
        return new PositiveNumber(number);
    }

    private static void checkPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 입력되었습니다.");
        }
    }

    public PositiveNumber plus(int number) {
        return new PositiveNumber(PLUS.apply(this.number, number));
    }

    public PositiveNumber plus(PositiveNumber number) {
        return new PositiveNumber(PLUS.apply(this.number, number.number));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positive = (PositiveNumber) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
