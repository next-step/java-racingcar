package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = validate(position);
    }

    private int validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position 값은 음수일 수 없습니다.");
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    @Override
    public int compareTo(Position o) {
        return this.position - o.position;
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
