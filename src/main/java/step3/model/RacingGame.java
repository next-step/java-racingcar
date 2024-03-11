package step3.model;

import step3.ui.InputView;
import step3.ui.ResultView;

import java.util.List;

public class RacingGame {
    private CarsManager carsManager = null;

    public RacingGame(int carCount) {
        this.carsManager = new CarsManager(carCount);
    }

    public void progressStage() {
        carsManager.tryMoveCars();
    }

    public List<Integer> getResult(){
        return carsManager.getCarsPosition();
    }


}
