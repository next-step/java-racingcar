package calculator;

import java.util.Objects;

public class PositiveInteger {

    public static final PositiveInteger ZERO = new PositiveInteger("0");

    private final int value;

    public PositiveInteger(String value) {
        this(parseInt(value));
    }

    public PositiveInteger(int value) {
        if (value < 0) {
            throw new NumberFormatException("minus");
        }
        this.value = value;
    }

    public PositiveInteger plus(PositiveInteger positiveInteger) {
        Objects.requireNonNull(positiveInteger);
        return new PositiveInteger(value + positiveInteger.value);
    }

    private static int parseInt(String value) {
        if (isBlank(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public int intValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveInteger that = (PositiveInteger) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
