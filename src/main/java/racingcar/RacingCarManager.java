package racingcar;

import java.util.List;

public class RacingCarManager {

    private final List<RacingCar> racingCars;

    public RacingCarManager(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void moveIfMovable(RacingCarMoveStrategy moveStrategy) {
        for (RacingCar car : racingCars) {
            car.moveIfMovable(moveStrategy);
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

}
