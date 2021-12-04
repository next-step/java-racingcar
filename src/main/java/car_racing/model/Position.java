package car_racing.model;


import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        position ++;
    }

    public int getPosition() {
        return position;
    }

    public Position getMaxPosition(Position other) {
        return new Position(Math.max(position, other.position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position other = (Position) o;
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}