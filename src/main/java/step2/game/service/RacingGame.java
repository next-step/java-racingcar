package step2.game.service;

import step2.game.domain.Cars;
import step2.game.domain.RacingGameRecord;
import step2.game.dto.RacingGameInputModel;
import step2.game.dto.RacingGameResultModel;

public class RacingGame {
    private final RacingGameInputModel racingGameInputModel;

    public RacingGame(RacingGameInputModel racingGameInputModel) {
        this.racingGameInputModel = racingGameInputModel;
    }

    public RacingGameResultModel start() {
        Cars cars = Cars.newCars(racingGameInputModel.getCarNames());
        RacingGameRecord racingGameRecord = RacingGameRecord.newGame(cars.startTurn());

        int times = racingGameInputModel.getTimes();
        for (int i = 1; i < times; i++) {
            Cars previousCars = racingGameRecord.previousTurn(i - 1);
            racingGameRecord.record(previousCars.startTurn());
        }

        return new RacingGameResultModel(racingGameRecord.getResult(), racingGameRecord.winners());
    }

}
