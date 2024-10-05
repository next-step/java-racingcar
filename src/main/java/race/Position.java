package race;

import java.util.Objects;

public class Position {

    private final int value;

    public Position(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Position not allowed minus");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Position))
            return false;
        Position position = (Position)o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
