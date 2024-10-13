package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int DEFAULT_POSITION = 0;
    private Integer position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(Integer position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position1 = (Position) o;

        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(position, other.position);
    }
}
