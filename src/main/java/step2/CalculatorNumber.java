package step2;

import java.util.Objects;

public class CalculatorNumber {
    private static final CalculatorNumber ZERO = new CalculatorNumber(0);
    private final int value;

    CalculatorNumber(int from) {
        value = from;
    }

    public static CalculatorNumber parse(String from) {
        return new CalculatorNumber(Integer.parseInt(from));
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
        if (CalculatorNumber.ZERO == other) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
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
