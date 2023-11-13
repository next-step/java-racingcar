package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position>{
    private static final int DEFAULT_MOVE_POSITION = 1;
    private int position;

    public Position move() {
        position += DEFAULT_MOVE_POSITION;
        return this;
    }

    public int position() {
        return position;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.position, other.position);
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