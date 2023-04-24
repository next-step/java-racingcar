package study;

import java.util.Objects;

public class MoveCount {
    private int moveCount;

    public void moveForward() {
        moveCount++;
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

    public MoveCount(int number) {
        this.moveCount = number;
    }

    public MoveCount() {
        new MoveCount(0);
    }

    public boolean checkIsSame(int maxCountValue) {
        return moveCount == maxCountValue;
    }

    public int getCount() {
        return this.moveCount;
    }
}
