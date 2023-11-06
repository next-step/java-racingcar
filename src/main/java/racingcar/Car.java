package racingcar;

public class Car {
    private int moveCount;

    public int moveCount() {
        return moveCount;
    }

    public void move() {
        ++moveCount;
    }
}
