package laststep.domain;

import java.util.Objects;

public class Position {
    private static final int MINIMUM_POSITION = 1;
    private final int position;

    public Position() {
        this(1);
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    public Position increase() {
        return new Position(position + 1);
    }

    public boolean isPosition(Position other) {
        return position == other.position;
    }

    private void validate(int position) {
        if (position < MINIMUM_POSITION) {
            throw new IllegalArgumentException("위치가 1미만일 수 없어요");
        }
    }

    public String print() {
        return String.valueOf(position);
    }

    public int compare(Position other) {
        return this.position - other.position;
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
