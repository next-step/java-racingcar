package racingcar;

import java.util.Objects;

public class Position {

    public static final int INITIAL_POSITION = 0;
    private static final String ERROR_NEGATIVE_VALUE = "위치는 음수가 될 수 없습니다.";

    private final int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position move() {
        return new Position(this.value + 1);
    }

    public Position max(Position other) {
        if (other.value > this.value) {
            return other;
        }
        return this;
    }

    public int asInt() {
        return value;
    }

    public boolean isGreaterThan(Position position) {
        return this.value > position.value;
    }

    private static void validate(int value) {
        if (value < INITIAL_POSITION) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_VALUE);
        }
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
        return Objects.hashCode(value);
    }
}
