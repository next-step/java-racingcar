package RacingGame.service;

import RacingGame.common.RandomNumberGenerator;
import RacingGame.model.CarsManager;
import RacingGame.model.MovableStrategy;
import RacingGame.model.RacingResult;

import java.util.List;

public class RacingGameService {
    private final MovableStrategy movableStrategy;

    public RacingGameService() {
        this(new MovableStrategy(new RandomNumberGenerator()));
    }

    public RacingGameService(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    private void progressStage(CarsManager carsManager) {
        carsManager.tryMoveCars(movableStrategy);
    }

    public RacingResult play(String carNames, int stages) {
        List<String> carNameList = splitCarNames(carNames);

        CarsManager carsManager = CarsManager.withCarNames(carNameList);
        RacingResult racingResult = new RacingResult(carNameList, stages);

        for (int i = 0; i < stages; i++) {
            progressStage(carsManager);
            racingResult.addStage(carsManager.carNamePositions());
        }

        return racingResult;
    }

    public List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }
}
