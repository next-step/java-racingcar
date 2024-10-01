package javaracingcar.entity;

public class RacingCar {

    private static final int DEFAULT_MOVE_COUNT = 0;
    private static final int ADD_MOVE = 1;
    private static final int MIN_MOVING_RANGE = 4;
    private static final int MAX_MOVING_RANGE = 9;

    private int moveCount = DEFAULT_MOVE_COUNT;

    public RacingCar() {
    }

    public boolean isMove(int randomValue) {
        if (MIN_MOVING_RANGE <= randomValue && randomValue <= MAX_MOVING_RANGE) {
            return true;
        }
        return false;
    }

    public void go() {
        this.moveCount += ADD_MOVE;
    }

    public int moveCount() {
        return this.moveCount;
    }

}
