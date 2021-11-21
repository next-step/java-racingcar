package racing.model;

import java.util.Objects;
import java.util.Optional;

/**
 * .
 */
public class Position {

    private static final int CRITERIA = 4;

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public Position moveOnSatisfiedCondition(int condition) {
        if (condition > CRITERIA) {
            return new Position(position + 1);
        }
        return this;
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
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
