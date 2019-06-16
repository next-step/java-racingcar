package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void run() {
        initialize();
        int numberOfCars = InputView.inputNumberOfCars();
        int numberOfTries = InputView.inputNumberOfTries();
        createCars(numberOfCars);
        OutputView.printRoundSeparator();
        OutputView.printResultMessage();
        tryStep(numberOfTries);
    }

    private void initialize() {
        cars = new ArrayList<>();
    }

    private void createCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            Car car = Car.createCar();
            cars.add(car);
        }
    }

    private void tryStep(int numberOfTries) {
        for (int i = 0; i < numberOfTries; i++) {
            moveCars();
            OutputView.printRoundSeparator();
        }
    }

    private void moveCars() {
        for (Car car :
                cars) {
            int position = car.move();
            OutputView.printCarPosition(position);
        }
    }
}
