package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private static int numOfCar;
    private static int numOfCycle;
    private static String nameOfCar;
    private static final int INIT_CAR_POSITION = 1;
    private static String maxCarName;
    private static int maxCarPosition = 0;

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private List<CarManager> carManagers;

    public Race(String nameOfCar, int numOfCycle) {
        this.nameOfCar = nameOfCar;
        this.numOfCar = getNumOfCar();
        this.numOfCycle = numOfCycle;
        validInputConfirm();
        prepareCars();
    }

    public int getNumOfCar() {
        return nameOfCar.split(",").length;
    }

    public void prepareCars() {
        String[] carNamesAry = nameOfCar.split(",");
        carManagers = new ArrayList<>();
        for (int i = 0; i < numOfCar; i++) {
            Car car = new Car(INIT_CAR_POSITION,carNamesAry[i]);
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
            resultView.showCurrCarName(carManager.getCurrCarName());
            resultView.showCurrCarPosition(carManager.getCurrCarPosition());
            findMaxPositionCarName(carManager.getCurrCarName(), carManager.getCurrCarPosition());
        }
    }

    public void findMaxPositionCarName(String carName, int carPosition) {
        if (carPosition > maxCarPosition) {
            maxCarName = carName;
            maxCarPosition = carPosition;
            return;
        }
        if (carPosition == maxCarPosition) {
            maxCarName += ", "+carName;
            return;
        }
    }

    public String getMaxCarName() {
        return maxCarName;
    }



}
