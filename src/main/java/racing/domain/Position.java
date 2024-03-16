package racing.domain;

import java.util.Objects;

public class Position {
    private int value;

    public Position(int position) {
        this.value = position;
    }

    public int value() {
        return value;
    }

    public void increase() {
        this.value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
