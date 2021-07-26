package racing.model;

public class Number {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

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

    boolean isGreaterThanOrEqualTo(int number) {
        return this.number >= number;
    }
}
