package racinggame.domain.racing;

import racinggame.domain.car.Car;

import java.util.List;

public class RoundResult {
    private RacingCars result;

    public RoundResult(RacingCars racingCars) {
        this.result = new RacingCars(racingCars);
    }

    public RacingCars getResult() {
        return result;
    }
}
