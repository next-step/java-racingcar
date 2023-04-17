package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.ResultView.printWinner;

public class RacingGame {

    public static void main(String[] args) {
        String[] carNames = initNameOfCars();
        Integer numberOfAttempts = initNumberOfAttempts();

        Cars cars = new Cars(initCars(carNames));

        List<Car> winners = playGame(numberOfAttempts, cars);
        printWinner(winners);
    }

    private static List<Car> playGame(Integer numberOfAttempts, Cars cars) {
        ResultView.printHeader();
        for (int i = 0; i < numberOfAttempts; i++) {
            round(cars);
        }
        return cars.findWinner();
    }

    private static void round(Cars cars) {
        ResultView.printCarDistance(cars.forward());
    }

    private static Integer initNumberOfAttempts() {
        InputView.printNumberOfAttempts();
        return ConsoleScanner.inputInt();
    }

    private static String[] initNameOfCars() {
        InputView.printNameOfCars();
        return ConsoleScanner.inputString().split(",");
    }

    private static List<Car> initCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
