package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.GameStep;
import racingcar.domain.Record;
import racingcar.domain.Records;

public class RacingGameService implements GameService {
    private Cars cars;
    private GameStep gameStep;

    @Override
    public void init(String carNames, int stepNumber) {
        gameStep = new GameStep(stepNumber);
        cars = new Cars(carNames);
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
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        cars.move(moveStrategy);
        gameStep.increaseStep();
    }
}
