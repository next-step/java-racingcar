package racingcar.domain;

import racingcar.domain.strategyPattern.MoveStrategy;
import racingcar.util.RandomNumberGenerator;

public class RacingCar {
    private static final int MIN_MOVE_COUNT = 4;
    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }
}
