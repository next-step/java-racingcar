package calculator;

import java.util.Objects;

public class PositiveInteger {

    private final int value;

    public PositiveInteger(String value) {
        this.value = parse(value);
    }

    private static int parse(String value) {
        if (isBlank(value)) {
            return 0;
        }
        return parsePositiveInt(value);
    }

    private static int parsePositiveInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new NumberFormatException("minus");
        }
        return number;
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
