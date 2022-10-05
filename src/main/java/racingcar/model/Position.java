package racingcar.model;

import java.util.Objects;

public class Position {

    private static final int START_POSITION = 0;

    private final int value;

    public Position() {
        this.value = START_POSITION;
    }

    public Position(final int value) {
        if (value < 0) {
            throw new IllegalStateException("0 미만의 수는 Position이 될 수 없습니다.");
        }
        this.value = value;
    }

    Position moveForward() {
        return new Position(this.value + 1);
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

    public int getValue() {
        return value;
    }
}
