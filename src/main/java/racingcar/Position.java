package racingcar;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private final int value;

    public Position of() {
        return new Position(value);
    }

    public Position() {
        this(0);
    }

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다.");
        }
    }

    public int value() {
        return value;
    }

    public Position nextPosition() {
        return new Position(value + 1);
    }

    @Override
    public int compareTo(Position other) {
        return this.value - other.value;
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
