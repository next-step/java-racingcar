package racingGame.domain.car;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private static void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position must be greater than 0");
        }
    }

    public void move() {
        position++;
    }

    public int getPosition() {
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
