package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int position;

    private final int DEFAULT_MOVE_POINT = 1;

    public Position(final int position) {
        this.position = position;
    }

    public Position move() {
        return new Position(position + DEFAULT_MOVE_POINT);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position otherPosition = (Position) o;
        return position == otherPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
    }
}
