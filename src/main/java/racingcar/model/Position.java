package racingcar.model;

public class Position {
    private static final int POSITION_INITIAL_VALUE = 0;
    private int position;

    public Position() {
        this(POSITION_INITIAL_VALUE);
    }

    Position(int position) {
        this.position = position;
    }

    public void increaseValue() {
        position = position + 1;
    }

    public int getValue() {
        return position;
    }
}
