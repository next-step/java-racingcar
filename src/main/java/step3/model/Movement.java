package step3.model;

public class Movement {
    private static final int DEFAULT_COUNT = 0;

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

    public void move() {
        moveCount++;
    }
}
