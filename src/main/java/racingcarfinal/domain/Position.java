package racingcarfinal.domain;

public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 미만일 수 없습니다.");
        }
    }

    public Position increase() {
        return new Position(position + 1);
    }

    public int getIntValue() {
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
        return position;
    }

}
