package racing;

import static racing.NumberGenerator.MAX_VALUE;
import static racing.NumberGenerator.MIN_VALUE;

public class Number {
    private int value;

    Number(int value) {
        validateRange(value);
        this.value = value;
    }

    int getValue() {
        return value;
    }

    private void validateRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("값이 유효한 범위 안에 있지 않습니다. (value: %d)", value));
        }
    }
}
