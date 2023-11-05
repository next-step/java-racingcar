package racingcar.domain;

public class Car {

    private static final int INCREASE_STANDARD_NUMBER = 4;
    private int moveCount = 0;

    public void stopOrMove(int randomValue) {
        if (INCREASE_STANDARD_NUMBER <= randomValue) {
            moveCount += 1;
        }
    }

    public int getMoveCount() { return moveCount; }
}
