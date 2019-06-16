package step2;

import java.util.List;

public class RacingGame {
    private final RacingGameInputModel racingGameInputModel;

    public RacingGame(RacingGameInputModel racingGameInputModel) {
        this.racingGameInputModel = racingGameInputModel;
    }

    public List<Cars> start() {
        Cars cars = Cars.newCars(racingGameInputModel.getNumberOfCar());
        RacingGameRecord record = RacingGameRecord.newGame(cars.startTurn());

        for (int i = 1; i < racingGameInputModel.getTimes(); i++) {
            Cars previousCars = record.previousTurn(i - 1);
            record = record.record(previousCars.startTurn());
        }

        return record.getResult();
    }

}
