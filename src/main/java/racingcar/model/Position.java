package racingcar.model;

public class Position {

    private final int position;

    private static final String DELIMITER = "-";

    public Position() {
        this(0);
    }

    public Position(int initialPosition) {
        this.position = initialPosition;
    }

    public Position incrementPosition() {
        return new Position(this.position + 1);
    }

    public boolean isSameAs(Position other) {
        return this.position == other.position;
    }

    @Override
    public String toString() {
        return DELIMITER.repeat(position);
    }
}
