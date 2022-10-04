package calculator;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number) {
        validateIsPositive(number);
        this.number = number;
    }

    private void validateIsPositive(int number) {
        if (number < 0) {
            throw new NumberFormatException("0보다 작을 수 없습니다.");
        }
    }

    public static Number parse(String input) {
        return new Number(parseInt(input));
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
