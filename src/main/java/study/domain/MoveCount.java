package study.domain;

import java.util.Objects;

public class MoveCount {
    private int moveCount;

    public MoveCount() {
        new MoveCount(0);
    }

    public MoveCount(int number) {
        this.moveCount = number;
    }

    public void moveForward() {
        moveCount++;
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
