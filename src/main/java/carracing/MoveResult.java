package carracing;


public class MoveResult {
    private final int straightCount;

    public MoveResult() {
        this.straightCount = 0;
    }

    public MoveResult(final int straightCount) {
        this.straightCount = straightCount;
    }

    public MoveResult applyMoveResult(boolean moved) {
        if (moved) {
            return new MoveResult(this.straightCount + 1);
        }

        return this;
    }

    public int getStraightCount() {
        return straightCount;
    }
}
