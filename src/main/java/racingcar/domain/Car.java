package racingcar.domain;

public class Car {
    private int moveCount;

    public Car() {
        this.moveCount = 0;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void reset() {
        this.moveCount = 1;
    }

    public void move() {
        this.moveCount++;
    }

}
