package racing.domain;

import java.util.Objects;

public class Position {

    private static final String INVALID_POSITION_MESSAGE = "위치는 0 이상이어야 합니다.";
    private static final int MINIMUM_POSITION = 0;
    private static final int MOVE_UNIT = 1;

    private final int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MINIMUM_POSITION) {
            throw new RuntimeException(INVALID_POSITION_MESSAGE);
        }
    }

    public Position move() {
        return new Position(value + MOVE_UNIT);
    }

    public int value() {
        return value;
    }

    public Position biggerPosition(Position other) {
        if (this.value > other.value) {
            return this;
        }
        return other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
