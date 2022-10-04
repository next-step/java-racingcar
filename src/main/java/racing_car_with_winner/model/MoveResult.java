package racing_car_with_winner.model;

public class MoveResult {
    private final int moveCount;

    public MoveResult() {
        this.moveCount = 0;
    }

    public MoveResult(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("전진 결과는 음수가 될 수 없습니다");
        }
        this.moveCount = moveCount;
    }

    public MoveResult move() {
        return new MoveResult(this.moveCount + 1);
    }
}
