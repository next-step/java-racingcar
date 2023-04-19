package racingcar.domain;

import java.util.Objects;

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

    public MoveCount increase() {
        this.moveCount++;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveCount moveCount1 = (MoveCount) o;
        return moveCount == moveCount1.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }
}
