package study;

import java.util.Objects;

public class Operand {

    public static final Operand ZERO = new Operand(0);
    private double value;

    public Operand(double value) {
        this.value = value;
    }

    public Operand(String value) {
        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return Double.compare(operand.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
