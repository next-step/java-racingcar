package racinggame;

import java.util.Objects;

public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
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

    public Position add() {
        return new Position(position + 1);
    }
}
