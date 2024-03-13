package step4.view.result;

public class CarMovementResult {
    private final int moveCount;

    public static CarMovementResult from(int moveCount) {
        return new CarMovementResult(moveCount);
    }

    private CarMovementResult(int moveCount) {
        this.moveCount = moveCount;
    }

    public int moveCount() {
        return moveCount;
    }
}
