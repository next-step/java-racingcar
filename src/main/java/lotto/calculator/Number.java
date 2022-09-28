package lotto.calculator;

import java.util.Objects;

public class Number {
    private final Long number;

    public Number(String number) {
        this.number = Long.parseLong(number);
    }

    public Number(Long number) {
        this.number = number;
    }

    public Long number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(this.number, number.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    Number add(Number number) {
        return new Number(this.number + number.number);
    }

    Number subtract(Number number) {
        return new Number(this.number - number.number);
    }

    Number multiply(Number number) {
        return new Number(this.number * number.number);
    }

    Number divide(Number number) {
        return new Number(this.number / number.number);
    }
}
