package racingCar.car.move;

import racingCar.car.RacingCar;
import util.RandomUtils;

public class RacingCarMoveForward implements RacingCarMoveDirectionStrategy {

    @Override
    public RacingCarMoveDirection getDirection() {
        return RacingCarMoveDirection.FORWARD;
    }

    @Override
    public RacingCar moveAndSetPosition(RacingCar racingCar) {
        int randomSinglePositiveDigit = RandomUtils.getRandomSinglePositiveDigit();
        racingCar.moveForward();
        return racingCar;
    }
}
