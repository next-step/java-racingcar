package racingcar.domain;

import java.util.Objects;

public final class Position implements Comparable<Position> {

    private static final String NOT_POSITIVE_MESSAGE = "위치는 음수가 될 수 없습니다.";

    private int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position from(final int position) {
        validate(position);
        return new Position(position);
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        this.value++;
    }

    private static void validate(final int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_MESSAGE);
        }
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
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final Position o) {
        return value - o.value;
    }
}
