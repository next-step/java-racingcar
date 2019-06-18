package racingcar.controller;

import racingcar.model.CarInformation;
import racingcar.model.Cars;
import racingcar.model.Referee;

import java.util.List;

public class RacingGame {
    private Cars cars;

    public RacingGame(List<String> carNames) {
        this.cars = Cars.createWithNames(carNames);
    }

    public List<CarInformation> raceOneStep() {
        return cars.move();
    }

    public List<CarInformation> awards() {
        return Referee.judgeWinners(cars);
    }
}
