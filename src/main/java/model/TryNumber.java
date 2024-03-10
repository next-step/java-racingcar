package model;

public class TryNumber {

    private final int value;

    public TryNumber(final int value) {
        validatePositive(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validatePositive(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }
}
