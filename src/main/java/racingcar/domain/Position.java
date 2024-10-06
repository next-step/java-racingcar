package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final String NEGATIVE_POSITION_MESSAGE = "음수 포지션은 존재할 수 없습니다.";
    private static final int MOVE_AMOUNT = 1;
    private static final int INITIAL_POSITION = 0;

    private final int value;

    private Position(int position) {
        this.value = position;
    }

    public static Position valueOf(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_MESSAGE);
        }
        return new Position(position);
    }

    public static Position valueOfInitialPosition() {
        return new Position(INITIAL_POSITION);
    }

    public Position move() {
        return Position.valueOf(this.value + MOVE_AMOUNT);
    }

    public int value() {
        return this.value;
    }

    public boolean isSamePosition(int position) {
        return this.value == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.value, o.value);
    }
}
