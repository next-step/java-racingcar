package step4.domain.car.position;

import java.util.Objects;

public final class Position {
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public final void increase() {
        position++;
    }

    public final int position() {
        return position;
    }

    public Position getWinningPosition(Position other) {
        return this.position > other.position() ? this : other;
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
