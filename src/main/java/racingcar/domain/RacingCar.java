package racingcar.domain;

import racingcar.application.RacingCarPosition;
import racingcar.utils.Const;

public class RacingCar {
    private static final int NUMBER_MOVING_STANDARD = 4;
    public RacingCarPosition position = new RacingCarPosition(Const.INITIAL_NUM);
    private final String carName;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= NUMBER_MOVING_STANDARD;
    }
}
