package car.domain;

public final class MoveCount {
    private final int moveCount;
    private final MovingStrategy movingStrategy;

    public MoveCount() {
        movingStrategy = new DefaultStrategy();
        moveCount = 0;
    }

    public MoveCount(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
        moveCount = 0;
    }

    public MoveCount(int moveCount) {
        validateMoveCount(moveCount);
        movingStrategy = new DefaultStrategy();
        this.moveCount = moveCount;
    }

    public MoveCount(int moveCount, MovingStrategy movingStrategy) {
        this.moveCount = moveCount;
        this.movingStrategy = movingStrategy;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("자동차의 위치는 음수가 될 수 없습니다.");
        }
    }

    public MoveCount move(int inputNumber) {
        if (movingStrategy.isMovable(inputNumber)) {
            return new MoveCount(moveCount + 1);
        }
        return this;
    }
}
