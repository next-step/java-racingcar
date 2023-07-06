package racing.model;

import racing.exception.IllegalCountException;

public class Count {
    private final int value;

    public Count(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < 0) {
            throw new IllegalCountException();
        }
    }

    public int getValue() {
        return value;
    }
}
