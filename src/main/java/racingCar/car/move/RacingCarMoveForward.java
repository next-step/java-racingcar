package racingCar.car.move;

import racingCar.car.RacingCar;

public class RacingCarMoveForward implements RacingCarMoveDirectionStrategy {

    private static final RacingCarMoveForward instance;

    private RacingCarMoveForward() {}

    static {
        instance = new RacingCarMoveForward();
    }

    public static RacingCarMoveForward getInstance() {
        return instance;
    }

    @Override
    public RacingCar moveAndSetPosition(RacingCar racingCar) {
        racingCar.moveForward();
        return racingCar;
    }
}
