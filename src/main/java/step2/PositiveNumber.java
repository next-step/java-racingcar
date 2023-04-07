package step2;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(String value) {
        this.value = Integer.parseInt(value);
        requirePositiveValue();
    }

    private void requirePositiveValue() throws RuntimeException {
        if (value < 0) {
            throw new RuntimeException("PositiveNumber has only positive value");
        }
    }

    public int getValue() {
        return value;
    }
}
