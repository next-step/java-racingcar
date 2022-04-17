package racingcar.view.dto;

import racingcar.model.Cars;

public class RacingResult {
    private final Cars cars;

    public RacingResult(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return cars;
    }
}
