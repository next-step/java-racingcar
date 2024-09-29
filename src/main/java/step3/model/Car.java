package step3.model;

public class Car {
    private static final int INITIAL_COUNT = 0;
    private int moveCount;

    public Car() {
        this.moveCount = INITIAL_COUNT;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        moveCount++;
    }
}
