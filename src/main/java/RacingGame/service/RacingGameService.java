package RacingGame.service;

import RacingGame.common.RandomNumberGenerator;
import RacingGame.model.CarsManager;
import RacingGame.model.MovableStrategy;
import RacingGame.model.Record;

import java.util.List;

public class RacingGameService {
    private MovableStrategy movableStrategy;

    public RacingGameService() {
        movableStrategy = new MovableStrategy(new RandomNumberGenerator());
    }

    public RacingGameService(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    private void progressStage(CarsManager carsManager) {
        carsManager.tryMoveCars(movableStrategy);
    }

    public List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    public Record play(String carNames, int stageCount) {
        CarsManager carsManager = CarsManager.withCarNames(splitCarNames(carNames));
        Record record = new Record();

        for (int i = 0; i < stageCount; i++) {
            progressStage(carsManager);
            record.addStage(carsManager);
        }

        record.addWinners(carsManager.winnerNames());

        return record;
    }
}
