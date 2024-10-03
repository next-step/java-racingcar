package racing.dto;

import racing.exception.InvalidInputValueException;

public class RaceAttempt {

    private final int value;

    private RaceAttempt(int value) {
        validateValue(value);
        this.value = value;
    }

    public static RaceAttempt of(int value) {
        return new RaceAttempt(value);
    }

    protected void validateValue(int value) {
        if (value < 1) {
            throw new InvalidInputValueException("레이스 횟수는 1회 이상이여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
