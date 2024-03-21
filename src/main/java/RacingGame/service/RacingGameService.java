package RacingGame.service;

import RacingGame.common.RandomNumberGenerator;
import RacingGame.model.CarsManager;
import RacingGame.model.MovableStrategy;

import java.util.List;
import java.util.Map;

public class RacingGameService {
    private final MovableStrategy movableStrategy;
    private CarsManager carsManager;

    public RacingGameService() {
        this(new MovableStrategy(new RandomNumberGenerator()));
    }

    public RacingGameService(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
        this.carsManager = new CarsManager();
    }

    private void progressStage(CarsManager carsManager) {
        carsManager.tryMoveCars(movableStrategy);
    }

    public Map<String, Integer> play() {
        progressStage(carsManager);
        return carsManager.carNamePositions();
    }

    public void init(String carNames) {
        this.carsManager = CarsManager.withCarNames(splitCarNames(carNames));
    }

    public List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    public List<String> winners() {
        return carsManager.winnerNames();
    }
}
