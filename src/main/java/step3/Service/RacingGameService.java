package step3.Service;

import step3.Common.NumberGenerator;
import step3.Model.CarsManager;
import step3.Model.MovableStrategy;

import java.util.List;

public class RacingGameService {
    private MovableStrategy movableStrategy;
    private CarsManager carsManager = null;

    public RacingGameService(NumberGenerator numberGenerator){
        movableStrategy = new MovableStrategy(numberGenerator);
    }

    public void setCarCount(int carCount) {
        this.carsManager = new CarsManager(carCount);
    }

    public void progressStage() {
        carsManager.tryMoveCars(movableStrategy);
    }

    public List<Integer> getResult() {
        return carsManager.getCarsPosition();
    }
}
