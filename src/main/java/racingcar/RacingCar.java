package racingcar;

import racingcar.strategy.MoveStrategy;

public class RacingCar {
    private       int          position = 0;
    private final MoveStrategy moveStrategy;

    public RacingCar(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void goOrStop() {
        if (moveStrategy.shouldMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
