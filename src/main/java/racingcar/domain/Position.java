package racingcar.domain;

import java.util.Objects;

public class Position {
    public static final int MOVE_POSITION_CONDITION = 4;
    public static final int ZERO = 0;
    public static final String POSITION_VIEW = "-";

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public static Position init() {
        return new Position(ZERO);
    }

    public void move(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("0 에서 9 사이 숫자만 입력 가능합니다. 입력숫자:" + number);
        }

        if (number >= MOVE_POSITION_CONDITION) {
            position++;
        }
    }

    public String viewPosition() {
        return POSITION_VIEW.repeat(Math.max(0, position));
    }

    public int position() {
        return position;
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
