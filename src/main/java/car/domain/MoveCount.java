package car.domain;

public final class MoveCount {
    private final int moveCount;

    public MoveCount() {
        moveCount = 0;
    }

    public MoveCount(int moveCount) {
        validateMoveCount(moveCount);
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("자동차의 위치는 음수가 될 수 없습니다.");
        }
    }

    public MoveCount move() {
        return new MoveCount(moveCount + 1);
    }
}
