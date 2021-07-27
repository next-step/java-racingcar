package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private static int numOfCar;
    private static int numOfCycle;
    private static final int INIT_CAR_POSITION = 1;
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private List<CarManager> carManagers;

    public Race(int numOfCar, int numOfCycle) {
        this.numOfCar = numOfCar;
        this.numOfCycle = numOfCycle;
        validInputConfirm();
        prepareCars();
    }

    public void prepareCars() {
        carManagers = new ArrayList<>();
        for (int i = 0; i < numOfCar; i++) {
            Car car = new Car(INIT_CAR_POSITION);
            carManagers.add(new CarManager(car));
        }
    }

    public void validInputConfirm() {
        inputView.inputCarCheck(numOfCar);
        inputView.inputRoundCheck(numOfCycle);
    }

    public void playRace() {
        for (CarManager carManager: carManagers) {
            carManager.canIGo();
        }
    }

    public void printResult() {
        for (CarManager carManager: carManagers) {
            resultView.showCurrCarPosition(carManager.getCurrCarPosition());
        }
    }
}
