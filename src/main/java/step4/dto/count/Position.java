package step4.dto.count;

import step4.common.MyNumber;

import java.util.Objects;

public class Position {
    private int position;

    public Position() {
        this.position = MyNumber.ZERO.getValue();
    }

    public Position(int input) {
        this.position = input;
    }

    public Position(Position other) {
        this.position = other.position;
    }

    public void plusPosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(Position other) {
        return this.position >= other.position;
    }

    public Position maxPosition() {
        return new Position(this.position);
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
