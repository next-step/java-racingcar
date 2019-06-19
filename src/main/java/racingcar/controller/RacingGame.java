package racingcar.controller;

import racingcar.model.CarInformation;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.Referee;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<CarName> carNames) {
        this.cars = Cars.createWithNames(carNames);
    }

    public List<CarInformation> raceOneStep() {
        return cars.move();
    }

    public List<CarInformation> awards() {
        return Referee.judgeWinners(cars);
    }
}
