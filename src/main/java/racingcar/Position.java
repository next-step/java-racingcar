package racingcar;

import java.util.Objects;

public class Position {

    private final int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    public Position move() {
        return new Position(this.value + 1);
    }

    private static void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다.");
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
