package racingcar;

public class Car {
    private int moveCount;

    public void addMoveCount(int generateCondition, int moveCondition) {
        if (generateCondition >= moveCondition) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
