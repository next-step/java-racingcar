package racingcar.backend.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int INITIAL_POSITION = 0;

    private final int position;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(final int position) {
        this.position = position;
    }

    public static Position create(final int position) {
        return new Position();
    }

    public Position forward() {
        return new Position(position + 1);
    }

    public int gatValue() {
        return this.position;
    }

    @Override
    public int compareTo(Position other) {
        return this.position - other.position;
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
}
