import java.util.Objects;

public class Position implements Comparable<Position> {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Position position = (Position)o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(value, other.value);
    }

    public void add() {
        this.value++;
    }
}
