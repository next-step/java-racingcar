package racingcar.domain;

import racingcar.application.RacingCarPosition;
import racingcar.utils.Const;

public class RacingCar {
    private static final int NUMBER_MOVING_STANDARD = 4;
    private int position;
    public RacingCarPosition position2 = new RacingCarPosition(Const.INITIAL_NUM);

    public int move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            return ++position;
        }
        return position;
    }

    public int move2(MovingStrategy movingStrategy) {
        return position2.move(movingStrategy);
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= NUMBER_MOVING_STANDARD;
    }

    public int getPosition() {
        return position;
    }
}
