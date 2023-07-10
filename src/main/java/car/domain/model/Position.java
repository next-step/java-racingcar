package car.domain.model;

import java.util.Objects;

public final class Position {

    private static final int MOVING_LIMIT = 4;
    private static final String MOVING_EXPRESSION = "-";
    private final int position;

    public Position(final int movement) {
        position = movement;
    }

    public Position moveTo(final int randomNumber) {
        if (randomNumber < MOVING_LIMIT) {
            return this;
        }

        return new Position(position + 1);
    }

    public boolean isSamePosition(final int distance) {
        return position == distance;
    }

    public String getTotalDistance() {
        return MOVING_EXPRESSION.repeat(position) + "\n";
    }

    int getPosition() {
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
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
