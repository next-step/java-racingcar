package calculator;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String string) {
        int parse = parseNumber(string);
        if (parse < 0) {
            throw new IllegalArgumentException();
        }
        this.number = parse;
    }

    private int parseNumber(String string) {
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
