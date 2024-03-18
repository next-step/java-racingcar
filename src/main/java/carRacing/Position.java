package carRacing;

import java.util.Objects;

public class Position {
    private static final int MOVE_DISTANCE = 1;
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    public void addPosition() {
        this.position += MOVE_DISTANCE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof  Position)) {
            return false;
        }
        Position targetPosition = (Position) obj;
        return getPosition() == targetPosition.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
