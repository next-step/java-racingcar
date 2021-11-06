package calculator.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Operand {

    private static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.d+)?");

    private final double value;

    private Operand(double value) {
        this.value = value;
    }

    private static void verify(String value) {
        if (isNullOrEmpty(value) || !PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("올바른 형식의 피연산자가 아닙니다.");
        }
    }

    private static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }

    public static Operand of(String value) {
        verify(value);
        return of(Double.parseDouble(value));
    }

    public static Operand of(double value) {
        return new Operand(value);
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
