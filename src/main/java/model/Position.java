package model;

import java.util.Objects;

public class Position {
    private static final String HYPHEN = "-";
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        this.position += 1;
    }

    @Override
    public String toString() {
        return HYPHEN.repeat(this.position);
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
