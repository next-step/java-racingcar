package study.domain;

import java.util.Objects;

public class MoveCount {
    private int moveCount;
    private static final int DEFAULT_MOVE_COUNT = 0;
    private static final int MOVE_BOUNDARY = 4;

    public MoveCount() {
        new MoveCount(DEFAULT_MOVE_COUNT);
    }

    public MoveCount(int number) {
        this.moveCount = number;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVE_BOUNDARY) {
            moveCount++;
        }
    }

    public boolean checkIsSame(int maxCountValue) {
        return moveCount == maxCountValue;
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

    public int getCount() {
        return this.moveCount;
    }

}
