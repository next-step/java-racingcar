package racingcar.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(int position) {
        validate(position);

        this.position = position;
    }

    public int getValue() {
        return position;
    }

    public Position add(int distance) {
        return new Position(position + distance);
    }

    public Position add(Position other) {
        return add(other.getValue());
    }

    private void validate(int position) {
        if(position < 0) {
            throw new RuntimeException("위치는 음수일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position1 = (Position)o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
