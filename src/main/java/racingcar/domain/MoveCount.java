package racingcar.domain;

public class MoveCount {

    private int moveCount;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean isGreaterThan(int maxMoveCount) {
        return this.moveCount > maxMoveCount;
    }

    public boolean isEqualTo(int maxMoveCount) {
        return this.moveCount == maxMoveCount;
    }
}
