package racinggame.domain;

import java.util.Objects;

public class Position {

    private final int position;

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
