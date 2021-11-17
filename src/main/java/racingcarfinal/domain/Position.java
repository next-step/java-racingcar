package racingcarfinal.domain;

public final class Position {

    private static final int MIN_POSITION_VALUE = 0;

    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException("위치는 0 미만일 수 없습니다.");
        }
    }

    public Position move() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position other = (Position) o;

        return value == other.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

}
