package racing.domain;

import java.util.Objects;

public class Position {

    public static final int DEFAULT_POSITION = 0;
    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public Position(Position position) {
        this(position.position);
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(++position);
    }

    public int max(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isSame(int winnerPosition) {
        return position == winnerPosition;
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
}
