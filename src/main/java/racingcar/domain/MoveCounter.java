package racingcar.domain;

import java.util.Objects;

public class MoveCounter {
    private int moveCount;

    public MoveCounter() {
        this(0);
    }

    public MoveCounter(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("moveCount는 음수 값을 가질 수 없습니다.");
        }
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public MoveCounter move() {
        moveCount++;
        return this;
    }

    public boolean isMoveCountEqualMaxCount(int maxCount) {
        return moveCount == maxCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveCounter that = (MoveCounter) o;
        return moveCount == that.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }
}
