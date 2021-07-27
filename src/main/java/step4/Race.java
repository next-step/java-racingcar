package step4;

import java.util.Random;

public class Race {
    private int numOfCar;
    private int numOfCycle;
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private CarManager[] carManagers;

    public int[] requestInput() {
        numOfCar = inputView.getNumOfCar();
        numOfCycle = inputView.getNumOfCycle();
        return new int[]{numOfCar, numOfCycle};
    }

    public void prepareCars() {
        carManagers = new CarManager[numOfCar];
        for (int i = 0; i < numOfCar; i++) {
            Car car = new Car(1);
            carManagers[i] = new CarManager(car);
        }
    }

    public void validInputConfirm() {
        inputView.inputCarCheck(numOfCar);
        inputView.inputRoundCheck(numOfCycle);
    }

    public void playRace() {
        for (int i = 0; i < numOfCar; i++) {
            carManagers[i].canIGo();
        }
    }

    public void printResult() {
        for (int i = 0; i < numOfCar; i++) {
            resultView.showCurrCarPosition(carManagers[i].getCurrCarPosition());
        }

    }
}
