package racingcar;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();

        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTrials = inputView.getNumberOfTrials();

        CarFactory carFactory = new CarFactory(numberOfCars);
        List<Car> carList = carFactory.buildCars();

        OutputView outputView = new ConsoleOutputView();
        RacingManager racingManager = new RacingManager(numberOfTrials, carList);
        racingManager.startRacing(outputView);
    }
}
