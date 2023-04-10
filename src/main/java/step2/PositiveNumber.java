package step2;

public class PositiveNumber {

    private final int value;

    private PositiveNumber(int value) {
        this.value = value;
    }

    public static PositiveNumber valueOf(String value) {
        int parsedValue = Integer.parseInt(value);
        requirePositiveValue(parsedValue);
        return new PositiveNumber(parsedValue);
    }

    private static void requirePositiveValue(int value) throws RuntimeException {
        if (value < 0) {
            throw new RuntimeException("PositiveNumber has only positive value");
        }
    }

    public int getValue() {
        return value;
    }

    public PositiveNumber plus(PositiveNumber other) {
        int newValue = this.value + other.value;
        return new PositiveNumber(newValue);
    }
}
