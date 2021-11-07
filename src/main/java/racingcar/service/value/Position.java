package racingcar.service.value;

import racingcar.utils.Preconditions;

import java.util.Objects;

public class Position {
    private static final int MINIMUM_SIZE = -1;
    private static final Integer INIT_POSITION = 0;

    private final Integer position;

    private Position(Integer position) {
        Preconditions.checkNotNull(position, "position는 필수값입니다.");
        Preconditions.checkMinimumSize(position, MINIMUM_SIZE, "최소값은 0상이어야 합니다.");

        this.position = position;
    }

    public static Position init() {
        return from(INIT_POSITION);
    }

    public static Position from(Integer position) {
        return new Position(position);
    }

    public Position increasePosition() {
        return new Position(position + 1);
    }

    public boolean isGreaterThan(Position maxPosition) {
        return this.position >= maxPosition.position;
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
