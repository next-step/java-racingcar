package calculator;

import java.util.Objects;

public class Number {
    public final int number;

    public Number(String num) {
        this.number = Integer.parseInt(num);
    }

    public Number(int number) {
        this.number = number;
    }

    public Number add(Number other) {
        return new Number(this.number + other.number);
    }

    public Number subtract(Number other) {
        return new Number(this.number - other.number);
    }

    public Number multiply(Number other) {
        return new Number(this.number * other.number);
    }

    public Number divide(Number other) {
        return new Number(this.number / other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
