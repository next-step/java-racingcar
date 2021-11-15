package step3;

import java.util.Objects;

public class Position {
    private final int ZERO = 0;
    private int position;

    public Position() {
        this.position = ZERO;
    }

    public Position(int input) {
        this.position = input;
    }

    public Position(Position other) {
        this.position = other.position;
    }

    public void plusPosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return ZERO == position1.ZERO &&
                position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ZERO, position);
    }
}
