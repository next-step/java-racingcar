package racingcar.backend.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int position;

    public Position(final int position) {
        this.position = position;
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
