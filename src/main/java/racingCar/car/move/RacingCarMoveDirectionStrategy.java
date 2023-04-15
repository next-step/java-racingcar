package racingCar.car.move;

import racingCar.car.RacingCar;

public interface RacingCarMoveDirectionStrategy {

    RacingCarMoveDirection getDirection();
    RacingCar moveAndSetPosition(RacingCar racingCar);
}
