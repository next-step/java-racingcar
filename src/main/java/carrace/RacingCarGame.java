package carrace;

import carrace.view.InputView;
import carrace.view.ResultView;

import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarFactory carFactory = new CarFactory();

        int carCount = inputView.inputCarCount();
        int roundCount = inputView.inputTryCount();

        List<Car> cars = carFactory.createCars(carCount);
        CarRace carRace = new CarRace(cars);
        for (int i = 0; i < roundCount; i++) {
            carRace.start();
        }

        resultView.result(cars, roundCount);
    }
}
