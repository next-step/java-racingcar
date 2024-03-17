package step3.service;

import step3.common.NumberGenerator;
import step3.model.CarsManager;
import step3.model.MovableStrategy;
import step3.model.Record;

import java.util.List;

public class RacingGameService {
    private MovableStrategy movableStrategy;

    public RacingGameService(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public Record play(int carCount, int stageCount) {
        CarsManager carsManager = CarsManager.withCarCount(carCount);
        Record record = new Record();

        for (int i = 0; i < stageCount; i++) {
            progressStage(carsManager);
            record.addStage(getResult(carsManager));
        }

        return record;
    }

    private void progressStage(CarsManager carsManager) {
        carsManager.tryMoveCars(movableStrategy);
    }

    private List<Integer> getResult(CarsManager carsManager) {
        return carsManager.getCarsPosition();
    }

}
