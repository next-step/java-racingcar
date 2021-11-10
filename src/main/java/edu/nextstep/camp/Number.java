package edu.nextstep.camp;

import java.util.Objects;

public class Number {
    private final int number;

    public static Number of(int n) {
        return new Number(n);
    }

    public static Number of(String n) {
        if (n == null || n.isEmpty())
            throw new IllegalArgumentException("value must not be empty: "+ n);
        return new Number(Integer.parseInt(n));
    }

    private Number(int n) {
        this.number = n;
    }

    public int toInt() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (getClass() == o.getClass())
            return number == ((Number) o).number;

        if (o.getClass() == Integer.class)
            return number == (Integer) o;

        if (o.getClass() == String.class)
            return number == Integer.parseInt((String) o);

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Number add(Number operand) {
        return new Number(this.number + operand.number);
    }

    public Number subtract(Number operand) {
        return new Number(this.number - operand.number);
    }

    public Number product(Number operand) {
        return new Number(this.number * operand.number);
    }

    public Number divide(Number operand) {
        if (operand.number == 0)
            throw new IllegalArgumentException("cannot calculate dividing by zero");
        return new Number(this.number / operand.number);
    }

}
