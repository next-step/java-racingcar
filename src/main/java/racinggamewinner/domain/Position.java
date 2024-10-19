package racinggamewinner.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int positionNumber) {
        position = positionNumber;
    }

    public void updatePosition(int movement) {
        position += movement;
    }

    public int currentPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
