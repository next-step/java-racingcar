package study.racingcar;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
        this.position = position;
    }

    public Position() {
        this.position = 0;
    }

    public void move() {
        this.position += 1;
    }
    
    public int compare(Position position) {
        return Integer.compare(this.position, position.position);
    }

    public int getPosition() {
        return this.position;
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
