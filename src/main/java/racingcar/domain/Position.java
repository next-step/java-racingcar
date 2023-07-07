package racingcar.domain;

import racingcar.exception.NotPositivePositionException;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_VALUE = 1;
    public static final String NOT_POSITIVE_MESSAGE = "위치의 값이 0이하 입니다.";
    private final int value;

    public Position() {
        this(DEFAULT_VALUE);
    }

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new NotPositivePositionException(NOT_POSITIVE_MESSAGE);
        }
    }

    public Position increaseValue() {
        int increaseValue = this.getValue() + 1;
        return new Position(increaseValue);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
