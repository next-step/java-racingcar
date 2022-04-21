package calculator;

import java.util.Objects;

public class Operand {
    private static final int ZERO = 0;

    private final int value;

    public Operand(String value) throws NumberFormatException {
        this(Integer.parseInt(value));
    }

    public Operand(int value) {
        validatePositive(value);
        this.value = value;
    }

    public Operand() {
        this(ZERO);
    }

    private void validatePositive(int value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException(String.format("음수(%d)는 합을 구할 수 없다.", value));
        }
    }

    private boolean isNegative(int value) {
        return value < ZERO;
    }

    public int getValue() {
        return value;
    }

    public Operand add(Operand operand) {
        return new Operand(this.value + operand.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return this.value == operand.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
