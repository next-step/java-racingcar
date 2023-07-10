package calculator.domain;

import calculator.SplitUtils;

import java.util.Objects;

public class Operand {

    private final Integer value;

    public Operand(final String value) {
        this.value = SplitUtils.toPositiveNumber(value);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Operand operand = (Operand) other;
        return Objects.equals(value, operand.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
