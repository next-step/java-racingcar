package carRacing;

import java.util.Objects;

public class Position {

    public Position() {
        new Position(0);
    }

    public Position(int value) {
        this.value = value;
    }

    private int value;

    public int value() {
        return value;
    }

    public void plus() {
        value++;
    }

    public void printPosition() {
        for (int i = 0; i < value; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Position position = (Position) object;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
