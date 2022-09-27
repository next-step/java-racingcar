package step3;

import step3.domain.Car;
import step3.util.InputUtil;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.HashSet;
import java.util.Set;

public class Race {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        InputView inputView = new InputView();

        inputView.printNumberOfCarsQuestion();
        int numOfCars = InputUtil.getInputValue();

        inputView.printNumberOfRoundsQuestion();
        int numOfRounds = InputUtil.getInputValue();

        race(numOfCars, numOfRounds);
    }

    private static void race(int numOfCars, int numOfRounds) {
        Set<Car> cars = new HashSet<>(numOfCars);

        for (int i = 0; i < numOfCars; i++) {
            Car car = Car.create();
            cars.add(car);
        }
        end(cars, numOfRounds);
    }

    private static void end(Set<Car> cars, int numOfRounds) {
        ResultView resultView = new ResultView();
        resultView.printEndOfRace();

        for (int i = 0; i < numOfRounds; i++) {
            runOneRound(cars);
            resultView.printRaceResult(cars);
        }
    }

    private static void runOneRound(Set<Car> cars) {
        for (Car car : cars) {
            car.goOrStop();
        }
    }
}
