package racingcar.model;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int initialPosition) {
        this.position = initialPosition;
    }

    public void incrementPosition() {
        position += 1;
    }

    public boolean isSameAs(Position other) {
        return this.position == other.position;
    }

    @Override
    public String toString() {
        return String.valueOf(this.position);
    }
}
