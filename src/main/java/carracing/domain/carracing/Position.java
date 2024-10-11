package carracing.domain.carracing;

import java.util.Objects;

public class Position {
    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Position increase() {
        return new Position(this.value + 1);
    }

    public int compareMax(int max) {
        return Math.max(max, this.value);
    }

    public boolean isSame(int position) {
        return this.value == position;
    }
}
