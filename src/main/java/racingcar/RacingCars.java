package racingcar;

import java.util.List;

public class RacingCars {

    List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void race(CarMover carMover, int attemptNumber) {
        racingCars.forEach(racingCar -> racingCar.race(attemptNumber, carMover));
    }

    public int size() {
        return racingCars.size();
    }
}
