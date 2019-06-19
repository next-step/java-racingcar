package step2.game.service;

import java.util.List;

import step2.game.dto.RacingGameInputModel;
import step2.game.domain.Cars;
import step2.game.domain.RacingGameRecord;

public class RacingGame {
    private final RacingGameInputModel racingGameInputModel;

    public RacingGame(RacingGameInputModel racingGameInputModel) {
        this.racingGameInputModel = racingGameInputModel;
    }

    public List<Cars> start() {
        Cars cars = Cars.newCars(racingGameInputModel.getNumberOfCar());
        RacingGameRecord racingGameRecord = RacingGameRecord.newGame(cars.startTurn());

        int times = racingGameInputModel.getTimes();
        for (int i = 1; i < times; i++) {
            Cars previousCars = racingGameRecord.previousTurn(i - 1);
            racingGameRecord.record(previousCars.startTurn());
        }

        return racingGameRecord.getResult();
    }

}
