package racingcar.model;

import static racingcar.view.OutputView.MOVE;

public class Position {

    private final int position;

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

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return MOVE.repeat(position);
    }
}
