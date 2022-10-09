package step3_pobi.domain;

import java.util.Objects;

public class Position {

    private final int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("0이상의 값만 유효합니다.");
        }
        this.position = position;
    }

    public Position(String position) {
        this(Integer.parseInt(position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    Position increase() {
        return new Position(position + 1);
    }

    int maxPosition(int position) {
        if (position < this.position) {
            return this.position;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    boolean isMaxPosition(int position) {
        return this.position == position;
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
