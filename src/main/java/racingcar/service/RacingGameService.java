package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.GameStep;
import racingcar.domain.Record;
import racingcar.domain.Records;

public class RacingGameService implements GameService {
    private Cars cars;
    private GameStep gameStep;

    @Override
    public void init(int carNumber, int stepNumber) {
        gameStep = new GameStep(stepNumber);
        cars = new Cars(carNumber);
    }

    @Override
    public Records run() {
        Records records = new Records();
        while (gameStep.isRunning()) {
            runStep();
            records.addRecord(new Record(cars));
        }
        return records;
    }

    private void runStep() {
        cars.moveCars();
        gameStep.increaseStep();
    }


}
