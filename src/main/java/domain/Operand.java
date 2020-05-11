package domain;

import java.util.Objects;

public class Operand {
    public static final Operand ZERO = new Operand(0);
    private final double value;

    public Operand(double value) {
        this.value = value;
    }

    public Operand(String value) {
        validate(value);
        try {
            this.value = Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format("%s는 숫자로 변환할 수 없습니다", value));
        }
    }

    private void validate(String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException("null또는 빈 공백문자는 Operand로 변환할 수 없습니다");
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
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
