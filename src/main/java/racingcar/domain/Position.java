package racingcar.domain;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private final int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    private Position(int position) {
        assert position >= 0;
        this.position = position;
    }

    public Position move() {
        return new Position(getPosition() + 1);
    }

    public int getPosition() {
        return position;
    }
}
