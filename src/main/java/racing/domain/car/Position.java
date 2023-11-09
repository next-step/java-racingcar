package racing.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public int position() {
        return this.position;
    }

    Position move(int offset) {
        int currentPosition = this.position;
        return new Position(currentPosition + offset);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position p) {
        if (this.position < p.position) {
            return 1;
        }
        if (p.position == this.position) {
            return 0;
        }
        return -1;
    }
}
