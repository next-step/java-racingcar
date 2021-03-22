package racingcar.service;

import racingcar.domain.*;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService implements GameService {
    private Cars cars;
    private GameStep gameStep;

    @Override
    public void init(String carNames, int stepNumber) {
        gameStep = new GameStep(stepNumber);
        cars = new Cars(getCarNames(carNames));
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

    private Name[] getCarNames(String tmpCarNames) {
        String[] carNames = tmpCarNames.split(",");
        List<Name> names = new ArrayList<>();
        for (String name : carNames) {
            names.add(new Name(name));
        }
        return names.toArray(new Name[names.size()]);
    }

}
