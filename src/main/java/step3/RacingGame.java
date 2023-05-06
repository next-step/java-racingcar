package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    public static final List<Car> carList = new ArrayList<>();

    public static void main(String[] args) {
        int numOfCar = inputView.getNumOfCar();
        int numOfTrial = inputView.getNumOfTrial();

        resultView.printResultMessage();

        makeCars(numOfCar);
        for (int i = 0; i < numOfTrial; i++) {
            race();
        }
    }

    public static void makeCars(int numOfCar) {
        for (int i = 0; i < numOfCar; i++) {
            carList.add(new Car());
        }
    }

    public static void race() {
        raceEachCar(carList);
        printResultEachCar(carList);
    }

    public static void raceEachCar(List<Car> carList) {
        for (Car car : carList) {
            car.go();
        }
    }

    public static void printResultEachCar(List<Car> carList) {
        for (Car car : carList) {
            resultView.printTraceEachCar(car.getTrace());
        }
    }
}
