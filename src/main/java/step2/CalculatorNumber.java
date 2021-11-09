package step2;

import java.util.Objects;

public class CalculatorNumber {
    private int value;

    CalculatorNumber(String from) {
        value = Integer.parseInt(from);
    }

    CalculatorNumber(int from) {
        value = from;
    }

    CalculatorNumber plus(CalculatorNumber other) {
        return new CalculatorNumber(value + other.value);
    }

    CalculatorNumber minus(CalculatorNumber other) {
        return new CalculatorNumber(value - other.value);
    }

    CalculatorNumber times(CalculatorNumber other) {
        return new CalculatorNumber(value * other.value);
    }

    CalculatorNumber divideBy(CalculatorNumber other) {
        return new CalculatorNumber(value / other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorNumber calculatorNumber = (CalculatorNumber) o;
        return value == calculatorNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CalculatorNumber{" +
                "value=" + value +
                '}';
    }
}
