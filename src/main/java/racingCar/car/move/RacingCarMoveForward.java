package racingCar.car.move;

import racingCar.car.RacingCar;

public class RacingCarMoveForward implements RacingCarMoveDirectionStrategy {

    @Override
    public RacingCarMoveDirection getDirection() {
        return RacingCarMoveDirection.FORWARD;
    }

    @Override
    public RacingCar moveAndSetPosition(RacingCar racingCar) {
        racingCar.moveForward();
        return racingCar;
    }
}
