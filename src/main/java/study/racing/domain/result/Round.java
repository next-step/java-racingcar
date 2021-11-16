package study.racing.domain.result;

import java.util.List;

import study.racing.domain.car.Car;
import study.racing.domain.car.RacingCars;

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
