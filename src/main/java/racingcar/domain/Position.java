package racingcar.domain;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private final int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
