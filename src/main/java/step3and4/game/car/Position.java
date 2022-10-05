package step3and4.game.car;

import java.util.Objects;

public final class Position {

    private static final int DISTANCE_TO_MOVE = 1;

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position movedPosition() {
        return new Position(position + DISTANCE_TO_MOVE);
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
        final String bar = "-";
        return bar.repeat(position);
    }
}
