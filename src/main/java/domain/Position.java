package domain;

import java.util.Objects;

public class Position {

    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void move() {
        this.value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
