package racingcar.domain;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    public void increase(int n) {
        this.position += n;
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
