package step3.model;

public class Movement {
    private static final int DEFAULT_COUNT = 0;
    private static final int FORWARD = 1;
    private final int moveCount;

    public Movement() {
        this(DEFAULT_COUNT);
    }

    public Movement(final int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Movement move(){
        return new Movement(moveCount + FORWARD);
    }
}
