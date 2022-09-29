package car_racing;


public class MoveResult {
    private Integer straightCount;

    public MoveResult() {
        this.straightCount = 0;
    }

    public void applyMoveResult(boolean moved) {
        if (moved) {
            this.straightCount++;
        }
    }

    public Integer getStraightCount() {
        return straightCount;
    }
}
