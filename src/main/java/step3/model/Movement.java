package step3.model;

public class Movement {
    static final int DEFAULT_COUNT = 0;
    static final int FORWARD_COUNT = 1;

    private int moveCount;

    public Movement() {
        this(DEFAULT_COUNT);
    }

    public Movement(final int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Movement move() {
        return new Movement(this.moveCount + FORWARD_COUNT);
    }
}
