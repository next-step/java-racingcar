package racing.model;

import static racing.model.NumberGenerator.MIN_NUMBER;
import static racing.model.NumberGenerator.MAX_NUMBER;

public class Number {
    private int number;

    Number(int number) {
        validateRange(number);
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("값이 유효한 범위 안에 있지 않습니다. (number: %d)", number));
        }
    }
}
