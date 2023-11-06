package racingcar;

public class Car {
    public static final int INITIAL_MOVE_COUNT = 1;
    private int moveCount;
    public Car() {
        this.moveCount = INITIAL_MOVE_COUNT;
    }

    public int moveCount() {
        return moveCount;
    }

    public void move() {
        ++moveCount;
    }
}
