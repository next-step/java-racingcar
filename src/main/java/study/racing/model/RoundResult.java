package study.racing.model;

import study.racing.model.car.RacingCars;

public class RoundResult {

    private final RacingCars racingCars;

    public RoundResult(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars result() {
        return racingCars;
    }
}
