package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        String[] carNames = initNameOfCars();
        Integer numberOfAttempts = initNumberOfAttempts();

        List<Car> cars = initCars(carNames);

        List<Car> cars1 = playGame(numberOfAttempts, cars);
        
    }

    private static List<Car> playGame(Integer numberOfAttempts, List<Car> cars) {
        ResultView.printHeader();
        for (int i = 0; i < numberOfAttempts; i++) {
            round(cars);
        }
        return cars;
    }

    private static void round(List<Car> cars) {
        for (Car car : cars) {
            car.forward(RaceConditionGenerator.isForwardable());
        }
        ResultView.printCarDistance(cars);
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
