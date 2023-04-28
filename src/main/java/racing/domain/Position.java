package racing.domain;

public class Position {

    public static final int DEFAULT_POSITION = 0;
    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public Position(Position position) {
        this(position.position);
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(++position);
    }

    public int max(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isSame(int winnerPosition) {
        return position == winnerPosition;
    }
}
