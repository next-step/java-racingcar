package racingcar;

import java.util.List;

public class RacingCarManager {

    private final List<RacingCar> racingCars;

    public RacingCarManager(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void moveIfMovable() {
        for (RacingCar car : racingCars) {
            car.moveIfMovable();
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

}
