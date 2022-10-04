package racingcar.domain;

import java.util.Objects;
import java.util.stream.Stream;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        position++;
    }

    public Position getBigger(Position other) {
        if (this.position > other.position) {
            return this;
        }
        return other;
    }

    public int getPosition() {
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
