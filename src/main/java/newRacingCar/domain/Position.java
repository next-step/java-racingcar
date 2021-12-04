package newRacingCar.domain;

import java.util.Objects;

public class Position {
    private int position;

    Position(int position) {
        this.position = position;
    }

    public void move() {
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(Position maxPosition) {
        return this.position < maxPosition.getPosition();
    }

    public boolean isSamePosition(Position position) {
        return this.equals(position);
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
}
