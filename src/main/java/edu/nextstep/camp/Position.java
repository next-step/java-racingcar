package edu.nextstep.camp;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int INITIAL_POSITION = 0;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position ofZero() {
        return new Position(INITIAL_POSITION);
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

    @Override
    public int compareTo(Position o) {
        return position - o.position;
    }
}
