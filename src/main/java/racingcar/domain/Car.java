package racingcar.domain;

public class Car {

    private final int INCREASE_STANDARD_NUMBER = 4;
    private int moveCount = 0;

    public int stopOrMove(int randomValue) {
        if (INCREASE_STANDARD_NUMBER <= randomValue) {
            moveCount = moveCount + 1;
            return moveCount;
        }
        return moveCount;
    }
}
