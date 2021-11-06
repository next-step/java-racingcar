package racingcar.service.value;

import racingcar.utils.Preconditions;

import java.util.Objects;

public class Position {
    private Integer position;

    private Position(Integer position) {
        Preconditions.checkNotNull(position, "position는 필수값입니다.");

        this.position = position;
    }

    public static Position from(Integer integer) {
        return new Position(integer);
    }

    public void incrementPosition() {
        position++;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
