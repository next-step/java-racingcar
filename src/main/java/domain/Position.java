package domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private int position = 0;

    public void goForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int compareTo(Position o) {
        return position - o.position;
    }
}
