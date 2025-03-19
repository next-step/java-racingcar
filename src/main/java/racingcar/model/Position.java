package racingcar.model;

public class Position {

    private int position;

    private static final String DELIMITER = "-";

    public Position() {
        this.position = 0;
    }

    public Position(int initialPosition) {
        this.position = initialPosition;
    }

    public void incrementPosition() {
        position ++;
    }

    public boolean isSameAs(Position other) {
        return this.position == other.position;
    }

    @Override
    public String toString() {
        return DELIMITER.repeat(position);
    }
}
