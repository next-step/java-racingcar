package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

    private static final int CONDITION_NUMBER = 4;
    private static final int DEFAULT_MOVE_POSITION = 1;
    private int forwardCnt;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.ableMove()) {
            forwardCnt += DEFAULT_MOVE_POSITION;
        }
    }

    public int forwardCnt() {
        return forwardCnt;
    }

    public String carName() {
        return carName;
    }

    public boolean matchPosition(int maxPosition) {
        return forwardCnt == maxPosition;
    }
}
