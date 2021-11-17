package study.racing.domain.result;

import study.racing.domain.car.RacingCars;

public class Round {

    private final RacingCars racingCars;

    public Round(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars result() {
        return racingCars;
    }

    public RacingCars winners() {
        return racingCars.mostMovedCars();
    }
}
