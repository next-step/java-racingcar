package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_VALUE = 0;
    private static final int MIN_DISTANCE = 0;

    private final int value;

    public Position(final int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR] 위치는 " + MIN_VALUE + "이상이어야 합니다.");
        }

        this.value = value;
    }

    Position move(final int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException("[ERROR] 후진은 불가능합니다.");
        }

        return new Position(value + distance);
    }

    public int getDifferenceWith(final Position position) {
        return this.value - position.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Position position = (Position) other;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
