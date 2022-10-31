package racingCar;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position moveForward() {
        return new Position(this.position + 1);
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(final Position o) {
        return this.position - o.position;
    }
}
