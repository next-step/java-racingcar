package step3.service;

import step3.common.NumberGenerator;
import step3.model.CarsManager;
import step3.model.MovableStrategy;

import java.util.List;

public class RacingGameService {
    MovableStrategy movableStrategy;
    public RacingGameService() {
    }

    public void progressStage(CarsManager carsManager) {
        carsManager.tryMoveCars(movableStrategy);
    }

    public List<Integer> getResult(CarsManager carsManager) {
        return carsManager.getCarsPosition();
    }
}
