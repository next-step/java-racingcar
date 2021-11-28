package racing.refactor.domain;

import java.util.Objects;

public class Position {

    private int value;

    public Position(int position) {
        this.value = position;
    }

    public void move() {
        value++;
    }

    public int getValue() {
        return this.value;
    }

    public boolean higherThan(Position otherPosition) {
        return this.value < otherPosition.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1=(Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }
}
