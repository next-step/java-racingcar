package race;

import java.util.Objects;

public class Position {
    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    public Position move() {
        this.value++;
        return this;
    }

    public int getValue() {
        return this.value;
    }

    public int getMax(int value) {
        return Math.max(this.value, value);
    }

    public boolean isSame(int value) {
        return this.value == value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
