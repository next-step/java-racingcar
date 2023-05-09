package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    protected static List<Car> carList;

    public static void main(String[] args) {
        int numOfCar = InputView.getNumOfCar();
        int numOfTrial = InputView.getNumOfTrial();

        ResultView.printResultMessage();

        makeCars(numOfCar);
        for (int i = 0; i < numOfTrial; i++) {
            race();
            ResultView.newLine();
        }
    }

    public static void makeCars(int numOfCar) {
        carList = new ArrayList<>();
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
            ResultView.printTraceEachCar(car.getTrace());
        }
    }
}
