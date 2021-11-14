package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int MIN_VALUE = 0;
    private static final int STEP = 1;
    public static final Position ZERO_POSITION = new Position(0);

    private final int value;

    private Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static void verify(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("위치는 최소 0이상이어야 합니다.");
        }
    }

    public static Position from(int value) {
        verify(value);
        if (value == MIN_VALUE) {
            return ZERO_POSITION;
        }
        return new Position(value);
    }

    public Position move() {
        return Position.from(value + STEP);
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
