package calculator;

import java.math.BigInteger;
import java.util.Objects;

public class Number {

    private final BigInteger number;

    public Number(BigInteger number) {
        this.number = number;
    }

    public Number add(Number other) {
        return new Number(number.add(other.number));
    }

    public Number subtract(Number other) {
        return new Number(number.subtract(other.number));
    }

    public Number multiply(Number other) {
        return new Number(number.multiply(other.number));
    }

    public Number divide(Number other) {
        return new Number(number.divide(other.number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number1 = (Number) o;

        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
