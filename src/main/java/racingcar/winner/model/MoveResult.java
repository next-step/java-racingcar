package racingcar.winner.model;

import java.util.Objects;

public class MoveResult implements Comparable<MoveResult> {
    private final int moveCount;

    public MoveResult() {
        this.moveCount = 0;
    }

    public MoveResult(final int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("전진 결과는 음수가 될 수 없습니다");
        }
        this.moveCount = moveCount;
    }

    public MoveResult move(boolean isMoved) {
        if (isMoved) {
            return new MoveResult(this.moveCount + 1);
        }

        return this;
    }

    public int getMoveCount() {
        return moveCount;
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
        return moveCount == that.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }

    @Override
    public int compareTo(MoveResult o) {
        return Integer.compare(this.moveCount, o.moveCount);
    }
}
