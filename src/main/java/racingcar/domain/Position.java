package racingcar.domain;

public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public Position(Position position, int move_length) {
        this(position.getValue() + move_length);
    }

    public int getValue() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
