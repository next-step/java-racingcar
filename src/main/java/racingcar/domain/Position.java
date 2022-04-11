package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private final int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    private Position(int position) {
        assert position >= 0;
        this.position = position;
    }

    public Position move() {
        return new Position(getPosition() + 1);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
