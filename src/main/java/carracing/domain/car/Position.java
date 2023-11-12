package carracing.domain.car;

import java.util.Objects;

public class Position {
    private static final int START_POSITION = 1;
    private final int position;

    public Position() {
        this.position = START_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public static Position startPosition() {
        return new Position();
    }

    public int getPosition() {
        return this.position;
    }

    public Position move(int position) {
        return new Position(this.position + position);
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
