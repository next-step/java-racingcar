package racingcar.domain;

import racingcar.dto.RoundResult;

public class Round {
    private final Cars cars;

    public Round(Cars cars) {
        this.cars = cars;
    }

    public RoundResult play() {
        cars.act();

        return new RoundResult(cars.getCarPositions());
    }

    public Cars getCars() {
        return cars;
    }
}
