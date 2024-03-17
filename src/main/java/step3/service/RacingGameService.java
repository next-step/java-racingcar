package step3.service;

import step3.common.NumberGenerator;
import step3.model.CarsManager;
import step3.model.MovableStrategy;

import java.util.List;

public class RacingGameService {
    private MovableStrategy movableStrategy;
    private CarsManager carsManager = null;

    public RacingGameService(NumberGenerator numberGenerator) {
        movableStrategy = new MovableStrategy(numberGenerator);
    }

    public void setCarCount(int carCount) {
        this.carsManager = CarsManager.withCarCount(carCount);
    }

    public void progressStage() {
        carsManager.tryMoveCars(movableStrategy);
    }

    public List<Integer> getResult() {
        return carsManager.getCarsPosition();
    }
}
