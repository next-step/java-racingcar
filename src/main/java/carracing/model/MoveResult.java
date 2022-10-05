package carracing.model;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MoveResult)) {
            return false;
        }
        MoveResult that = (MoveResult) o;
        return straightCount == that.straightCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(straightCount);
    }

    public int getStraightCount() {
        return straightCount;
    }
}
