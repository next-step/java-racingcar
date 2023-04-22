package racingcar;

public class Car {

    private int moveCount = 0;

    public int getMoveCount() {
        return moveCount;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            moveCount++;
        }
    }
}