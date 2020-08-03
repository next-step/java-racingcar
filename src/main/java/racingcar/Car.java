package racingcar;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private int moveCount = 0;

    public void moveAndStop(int fuel) {

        if (isMoveCondition(fuel)) {
            moveCount++;
        }
    }

    private boolean isMoveCondition(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    public int getMoveCount() {
        return moveCount;
    }
}