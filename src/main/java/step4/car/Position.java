package step4.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final Position ZERO = new Position(0);

    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public static Position zero() {
        return ZERO;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return getValue() == position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public int compareTo(Position o) {
        if(this.value > o.value)
            return 1;
        else if (this.value == o.value)
            return 0;

        return -1;
    }
}
