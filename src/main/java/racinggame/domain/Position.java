package racinggame.domain;

import java.util.Objects;

class Position {
    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public boolean isMaxPosition(int that) {
        return this.value == that;
    }

    public int max(int that) {
        return Math.max(this.value, that);
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
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }
}
