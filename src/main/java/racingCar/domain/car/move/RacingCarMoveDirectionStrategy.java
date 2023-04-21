package racingCar.domain.car.move;

import racingCar.domain.car.RacingCar;

public interface RacingCarMoveDirectionStrategy {
    RacingCar moveAndSetPosition(RacingCar racingCar);
}
