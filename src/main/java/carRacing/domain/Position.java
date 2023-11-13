package carRacing.domain;

import java.util.Objects;

public class Position {
    private final int position;


    public Position(int position) {
        this.position = position;
    }

    public Position move() {
        return new Position(this.position + 1);
    }

    public boolean isSame(int i) {
        return this.position == i;
    }

    public int max(int max) {
        return Math.max(max, this.position);
    }

    public int position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
