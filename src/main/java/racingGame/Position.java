package racingGame;

import java.util.Objects;

public class Position {

    public static final Position ZERO = new Position(0);

    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다: " + value);
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Position move() {
        return new Position(value + 1);
    }

    public int max(int currentMax) {
        return Math.max(value, currentMax);
    }

    public boolean isSame(int target) {
        return value == target;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
