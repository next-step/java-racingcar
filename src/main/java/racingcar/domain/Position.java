package racingcar.domain;

import java.util.Objects;

public final class Position implements Comparable<Position> {

    private static final String NOT_POSITIVE_MESSAGE = "위치는 음수가 될 수 없습니다.";
    private static final int LOWER_BOUND = 0;

    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position from(final int position) {
        validate(position);
        return new Position(position);
    }

    public static Position of() {
        return new Position(LOWER_BOUND);
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        this.position++;
    }

    public Position matchPosition(final Position other) {
        if(position >= other.position) {
            return this;
        }
        return other;
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
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return position - o.position;
    }
}
