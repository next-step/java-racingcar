package racingcar.v2.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position>{
    private int position;

    public Position() {
        this(0);
    }

    public Position(String position) {
        this(Integer.parseInt(position));
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("이동거리는 음수가 될수 없습니다.");
        }
        this.position = position;
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

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.position, position.getPosition());
    }

    public void plus() {
        this.position++;
    }
}
