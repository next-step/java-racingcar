package study.racingcar;

public class Car {

     public int moveCount;

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    Car() {
        moveCount = 0;
    }
}
