package racing.domain;

import java.util.Objects;

public final class Position {

    private int pos;

    public Position(int pos) {
        this.pos = pos;
    }

    public Position add(int distance) {
        return new Position(this.pos + distance);
    }

    public int getPos() {
        return pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return pos == position.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos);
    }

}
