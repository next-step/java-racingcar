package edu.nextstep.camp;

import java.util.Objects;

public class Position {
    private int position;

    public static Position of(int position) {
        return new Position(position);
    }

    private Position(int position) {
        this.position = position;
    }

    public void forward() {
        this.position++;
    }

    public int toInt() {
        return position;
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
