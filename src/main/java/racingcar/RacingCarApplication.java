package racingcar;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int numberOfCars = inputView.inputNumberOfCars();
        int numberOfAttempts = inputView.inputNumberOfAttempts();

        OutputView outputView = new OutputView();
        outputView.printResultMessage();

        Cars cars = new Cars(numberOfCars);
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.attempt();
            outputView.printStatusFromScores(cars.getScores());
        }
    }
}
