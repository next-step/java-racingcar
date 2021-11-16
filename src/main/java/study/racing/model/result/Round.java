package study.racing.model.result;

import java.util.List;

import study.racing.model.car.Car;
import study.racing.model.car.RacingCars;

public class Round {

    private final RacingCars racingCars;

    public Round(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars result() {
        return racingCars;
    }

    public List<Car> winners() {
        return racingCars.mostMovedCars();
    }
}
