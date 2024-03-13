package step3.Service;

import step3.Model.CarsManager;

import java.util.List;

public class RacingGameService {
    private CarsManager carsManager = null;

    public RacingGameService setCarCount(int carCount) {
        this.carsManager = new CarsManager(carCount);
        return this;
    }

    public void progressStage() {
        carsManager.tryMoveCars();
    }

    public List<Integer> getResult() {
        return carsManager.getCarsPosition();
    }
}
