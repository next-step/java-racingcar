package racingcar.domain;

import racingcar.utils.OutputView;

public class Car {

    public static final int MOVE_CODITION_NUMBER = 4;
    public static final int DEFAULT_MOVE_COUNT = 0;

    private int moveCount = DEFAULT_MOVE_COUNT;

    public static Car create() {
        return new Car();
    }

    public void increaseMoveCount() {
        this.moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int randomNumber) {
        if (canMove(randomNumber)) {
            this.increaseMoveCount();
        }

        OutputView.outputMove(moveCount);
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= MOVE_CODITION_NUMBER;
    }
}
