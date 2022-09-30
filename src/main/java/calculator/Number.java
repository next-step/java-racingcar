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
            throw new IllegalArgumentException();
        }
    }

    public static Number parse(String string) {
        int parse = parseInt(string);
        return new Number(parse);
    }

    private static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException();
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
