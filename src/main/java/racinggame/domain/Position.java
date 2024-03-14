package racinggame.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position add() {
        return new Position(position + 1);
    }

    @Override
    public int compareTo(Position that) {
        return this.position - that.position;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Position position1 = (Position) that;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
