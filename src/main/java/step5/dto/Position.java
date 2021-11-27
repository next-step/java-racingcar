package step4.dto;

import java.util.Objects;

public class Position {
    private static final int ZERO = 0;
    private static final int CALCULATE_UNIT = 1;
    private int position;

    public Position() {
        this.position = ZERO;
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position plusPosition() {
        return new Position(this.position + CALCULATE_UNIT);
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
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
