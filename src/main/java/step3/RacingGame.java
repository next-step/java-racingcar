package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    public static final List<Car> carList = new ArrayList<>();

    public static void main(String[] args) {
        int numberOfCars = inputView.getNumberOfCars();
        int count = inputView.getCount();
        resultView.printResultMessage();

        makeCars(numberOfCars);
        for (int i = 0; i < count; i++) {
            race();
        }
    }

    public static void race() {
        raceEachTurn(carList);
        printResultOfThisTurn(carList);
    }

    public static void makeCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
    }

    private static void raceEachTurn(List<Car> carList) {
        for (Car car : carList) {
            car.goOrStop();
        }
    }

    private static void printResultOfThisTurn(List<Car> carList) {
        for (Car car : carList) {
            resultView.printTraceEachCar(car.getTrace());
        }
        resultView.newLine();
    }

}