package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        Integer numberOfCars = initNumberOfCars();
        Integer numberOfAttempts = initNumberOfAttempts();
        List<Car> cars = initCars(numberOfCars);

        playGame(numberOfAttempts, cars);
    }

    private static void playGame(Integer numberOfAttempts, List<Car> cars) {
        ResultView.printResult();
        for (int i = 0; i < numberOfAttempts; i++) {
            round(cars);
        }
    }

    private static void round(List<Car> cars) {
        for (Car car : cars) {
            car.forward(RaceConditionGenerator.isForwardable());
        }
        ResultView.printCarDistance(cars);
    }

    private static Integer initNumberOfAttempts() {
        InputView.printNumberOfAttempts();
        Integer numberOfAttempts = InputValue.inputInt();
        return numberOfAttempts;
    }

    private static Integer initNumberOfCars() {
        InputView.printNumberOfCars();
        Integer numberOfCars = InputValue.inputInt();
        return numberOfCars;
    }

    private static List<Car> initCars(Integer numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
