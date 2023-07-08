package racing.domain;

import java.util.Objects;

public class Position implements Comparable {
    private static final int INITIAL_POSITION = 1;
    private final Integer position;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public Position next() {
        return new Position(this.position + 1);
    }

    int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Object o) {
        return position.compareTo(((Position) o).position);
    }
}
