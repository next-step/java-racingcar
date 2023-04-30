package racing.domain;

import racing.util.InputValidator;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        this.position = InputValidator.validateCarPosition(position);
    }

    public Position increase() {
        return new Position(++this.position);
    }

    public Position max(Position position) {
        if (position.position >= this.position) {
            return position;
        }

        return this;
    }

    public int getPosition() {
        return this.position;
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
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
