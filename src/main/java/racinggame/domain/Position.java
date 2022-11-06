package racinggame.domain;

import java.util.Objects;

public final class Position implements Comparable<Position> {
    private int position;

    Position() {
        this(0);
    }

    Position(int position) {
        this.position = position;
    }

    public Position increase() {
        ++this.position;
        return this;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Position o) {
        return o.position - this.position;
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
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
