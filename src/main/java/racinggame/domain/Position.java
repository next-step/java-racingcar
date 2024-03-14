package racinggame.domain;

import java.util.Objects;

public class Position {
    public static final int FORWARD_COUNT = 1;
    public static final int INIT_POSITION_VALUE = 1;
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position create() {
        return new Position(INIT_POSITION_VALUE);
    }

    public Position move() {
        return new Position(position + FORWARD_COUNT);
    }

    public int compareTo(Position OtherPosition) {
        return this.position - OtherPosition.getPosition();
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
