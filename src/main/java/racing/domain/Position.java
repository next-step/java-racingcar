package racing.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int position;

    public Position(int position) {
        if(position < 0) {
            throw new IllegalArgumentException("이동거리는 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return this.position - o.position;
    }
}
